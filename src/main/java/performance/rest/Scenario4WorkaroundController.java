package performance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import performance.bussinesslogic.SpeedLimitServiceProto;

import java.util.List;

@Profile("no_load")
@RestController
@RequestMapping("/scenario4workaround")
public class Scenario4WorkaroundController {

    @Autowired(required = false)
    public List<SpeedLimitServiceProto> speedLimitServicePrototypes;

    @RequestMapping
    public String index() {
        SpeedLimitServiceProto speedLimitServiceProto = speedLimitServicePrototypes.get(0);
        return "Speed limit is " + speedLimitServiceProto.getCitySpeedLimit() + " km/h in city and " + speedLimitServiceProto
            .getHighwaySpeedLimit() + " km/h on highway";
    }

}
