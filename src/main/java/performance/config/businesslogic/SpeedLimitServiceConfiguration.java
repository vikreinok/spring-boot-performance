package performance.config.businesslogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import performance.bussinesslogic.SpeedLimitService;
import performance.bussinesslogic.ch.SpeedLimitServiceCH;
import performance.bussinesslogic.ch.SpeedLimitServiceDE;
import performance.contition.CountryCH;
import performance.contition.CountryDE;

@Configuration
public class SpeedLimitServiceConfiguration {

    @Autowired
    private SpeedLimitServiceCH speedLimitServiceCH;

    @Autowired
    private SpeedLimitServiceDE speedLimitServiceDE;


    @Bean
    @Conditional(CountryCH.class)
    public SpeedLimitService speedLimitServiceCH() {
        return speedLimitServiceCH;
    }

    @Bean
    @Conditional(CountryDE.class)
    public SpeedLimitService speedLimitServiceDE() {
        return speedLimitServiceDE;
    }

}
