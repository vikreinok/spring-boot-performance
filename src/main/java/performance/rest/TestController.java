package performance.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import performance.bussinesslogic.SpeedLimitService;
import performance.bussinesslogic.TesService;
import performance.bussinesslogic.ch.SpeedLimitServiceCH;

@RestController
public class TestController {

    private final SpeedLimitService speedLimitService;

    public TestController(SpeedLimitService speedLimitService) {
        this.speedLimitService = speedLimitService;
    }


    @RequestMapping
    public String index() {
        return "Speed limit is " + speedLimitService.getCitySpeedLimit() + " km/h in city and " + speedLimitService
                .getHighwaySpeedLimit() + " km/h on highway";
    }

}