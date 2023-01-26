package performance.bussinesslogic.ch;

import org.springframework.stereotype.Service;
import performance.bussinesslogic.SpeedLimitService;
import performance.contition.CountryDE;
import org.springframework.context.annotation.Conditional;

@Service
//@Conditional(CountryDE.class)
public class SpeedLimitServiceDE implements SpeedLimitService {

    @Override
    public int getHighwaySpeedLimit() {
        return 200;
    }
}
