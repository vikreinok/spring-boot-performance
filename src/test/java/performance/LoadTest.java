package performance;

import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import static io.gatling.javaapi.core.CoreDsl.listFeeder;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.core.CoreDsl.stressPeakUsers;
import static io.gatling.javaapi.http.HttpDsl.http;


/**
 *
 */
public class LoadTest extends Simulation {

    final FeederBuilder<Object> headerFeeder = listFeeder(Arrays.asList(
            Collections.singletonMap("X-Country", "CH"),
            Collections.singletonMap("X-Country", "DE")
    ));

    final ScenarioBuilder scenario1;
    final ScenarioBuilder scenario2;
    final ScenarioBuilder scenario3;

    {
        scenario1 = scenario("scenario1").exec(http("scenario1call")
                                                 .get("/scenario1")
                                                 .header("X-Country", "CH")
                                                 .basicAuth("user", "test")
                                         );

        scenario2 = scenario("scenario2").feed(headerFeeder.random())
                                    .exec(http("scenario2call")
                .get("/scenario2")
                .header("X-Country", "#{X-Country}")
                .basicAuth("user", "test")
        );

        scenario3 = scenario("scenario3").feed(headerFeeder.random())
                                    .exec(http("scenario3call")
                .get("/scenario3")
                .header("X-Country", "#{X-Country}")
                .basicAuth("user", "test")
        );
    }

    final HttpProtocolBuilder httpProtocol =
        http.baseUrl("http://localhost:8080")
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader(
                    "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
            );

    {
        setUp(
                scenario1.injectOpen(stressPeakUsers(1000).during(Duration.ofSeconds(30))),
                scenario2.injectOpen(stressPeakUsers(1000).during(Duration.ofSeconds(30))),
                scenario3.injectOpen(stressPeakUsers(1000).during(Duration.ofSeconds(30)))
        ).protocols(httpProtocol);
    }

}
