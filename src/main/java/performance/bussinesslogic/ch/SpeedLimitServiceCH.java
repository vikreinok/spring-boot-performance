package performance.bussinesslogic.ch;

import org.springframework.stereotype.Service;
import performance.bussinesslogic.SpeedLimitService;
import performance.contition.CountryCH;
import org.springframework.context.annotation.Conditional;

@Service
//@Conditional(CountryCH.class)
public class SpeedLimitServiceCH implements SpeedLimitService {

    @Override
    public int getHighwaySpeedLimit() {
        return 120;
    }
}
