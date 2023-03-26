package performance.bussinesslogic;

public interface SpeedLimitService {

    default int getCitySpeedLimit() {
        return 50;
    }

    int getHighwaySpeedLimit();
}
