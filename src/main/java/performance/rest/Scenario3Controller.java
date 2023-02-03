package performance.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import performance.bussinesslogic.SpeedLimitService;
import performance.bussinesslogic.annotation.AutowireCustom;

@RestController()
@RequestMapping("/scenario3")
public class Scenario3Controller {

    @AutowireCustom
    private SpeedLimitService speedLimitService;

    @RequestMapping
    public String index() {
        return "Speed limit is " + speedLimitService.getCitySpeedLimit() + " km/h in city and " + speedLimitService
                .getHighwaySpeedLimit() + " km/h on highway";
    }

}