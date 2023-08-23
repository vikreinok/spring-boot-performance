package performance.bussinesslogic.facotry;

import org.springframework.stereotype.Component;
import performance.Country;
import performance.bussinesslogic.SpeedLimitService;
import performance.bussinesslogic.ch.SpeedLimitServiceCH;
import performance.bussinesslogic.ch.SpeedLimitServiceDE;
import performance.context.CountryHolder;

@Component
public class SpeedLimitServiceFactory {
    private final SpeedLimitServiceCH speedLimitServiceCH;
    private final SpeedLimitServiceDE speedLimitServiceDE;

    public SpeedLimitServiceFactory(
        SpeedLimitServiceCH speedLimitServiceCH,
        SpeedLimitServiceDE speedLimitServiceDE) {
        this.speedLimitServiceCH = speedLimitServiceCH;
        this.speedLimitServiceDE = speedLimitServiceDE;
    }

    public SpeedLimitService getSpeedLimitService() {
        Country country = CountryHolder.getCountry();
        if (country == null) {
            throw new IllegalStateException("Country not set in CountryHolder");
        } else if (country == Country.CH) {
            return speedLimitServiceCH;
        } else if (country == Country.DE) {
            return speedLimitServiceDE;
        } else {
            throw new IllegalArgumentException("Unsupported country: " + country);
        }
    }
}
