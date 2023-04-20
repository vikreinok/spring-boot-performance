package performance.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import performance.bussinesslogic.SpeedLimitService;
import performance.bussinesslogic.facotry.SpeedLimitServiceFactory;

@RestController
@RequestMapping("/scenario1")
public class Scenario1Controller {

    final SpeedLimitServiceFactory speedLimitServiceFactory;

    public Scenario1Controller(SpeedLimitServiceFactory speedLimitServiceFactory) {
        this.speedLimitServiceFactory = speedLimitServiceFactory;
    }

    @RequestMapping
    public String index() {
        SpeedLimitService speedLimitService = speedLimitServiceFactory.getSpeedLimitService();

        return "Speed limit is " + speedLimitService.getCitySpeedLimit() + " km/h in city and " + speedLimitService
                .getHighwaySpeedLimit() + " km/h on highway";
    }

}