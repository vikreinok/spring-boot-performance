package performance.bussinesslogic;

import org.springframework.stereotype.Service;

public interface SpeedLimitService {

    default int getCitySpeedLimit() {
        return 50;
    }

    int getHighwaySpeedLimit();
}
