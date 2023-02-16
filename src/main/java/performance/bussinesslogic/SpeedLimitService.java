package performance.bussinesslogic;

import performance.annotation.AutowiredCustom;

public interface SpeedLimitService {

    @AutowiredCustom
    default int getCitySpeedLimit() {
        return 50;
    }

    int getHighwaySpeedLimit();
}
