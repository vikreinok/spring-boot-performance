package performance.rest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import performance.Country;
import performance.bussinesslogic.SpeedLimitService;
import performance.context.CountryHolder;

@RestController
@RequestMapping("/scenario2")
public class Scenario2Controller {

    private final BeanFactory beanFactory;

    public Scenario2Controller(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    private SpeedLimitService getSpeedLimitService() {
        final Country country = CountryHolder.getCountry();
        return beanFactory.getBean(SpeedLimitService.class.getSimpleName() + country.name(), SpeedLimitService.class);
    }

    @RequestMapping
    public String index() {
        return "Speed limit is " + getSpeedLimitService().getCitySpeedLimit() + " km/h in city and " + getSpeedLimitService()
            .getHighwaySpeedLimit() + " km/h on highway";
    }

}
