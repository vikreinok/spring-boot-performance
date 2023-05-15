package performance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import performance.bussinesslogic.SpeedLimitServiceProto;

@RestController
@RequestMapping("/scenario4")
public class Scenario4Controller {

    @Autowired(required = false)
    public SpeedLimitServiceProto speedLimitServiceProto;

    @RequestMapping
    public String index() {
        return "Speed limit is " + speedLimitServiceProto.getCitySpeedLimit() + " km/h in city and " + speedLimitServiceProto
                .getHighwaySpeedLimit() + " km/h on highway";
    }

}