package performance.bussinesslogic.ch;

import org.springframework.stereotype.Service;
import performance.bussinesslogic.SpeedLimitService;

@Service("SpeedLimitServiceDE")
public class SpeedLimitServiceDE implements SpeedLimitService {

    @Override
    public int getHighwaySpeedLimit() {
        return 200;
    }
}
