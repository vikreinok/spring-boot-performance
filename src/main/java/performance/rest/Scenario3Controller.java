package performance.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import performance.annotation.AutowiredCustom;
import performance.bussinesslogic.SpeedLimitService;

@RestController
@RequestMapping("/scenario3")
public class Scenario3Controller {

    @AutowiredCustom
    public SpeedLimitService speedLimitService;

    @RequestMapping
    public String index() {
        return "Speed limit is " + speedLimitService.getCitySpeedLimit() + " km/h in city and " + speedLimitService
            .getHighwaySpeedLimit() + " km/h on highway";
    }

}
