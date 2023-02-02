package performance.bussinesslogic.ch;

import org.springframework.stereotype.Service;
import performance.bussinesslogic.SpeedLimitService;

@Service("SpeedLimitServiceCH")
//@Conditional(CountryCH.class)
public class SpeedLimitServiceCH implements SpeedLimitService {

    @Override
    public int getHighwaySpeedLimit() {
        return 120;
    }
}
