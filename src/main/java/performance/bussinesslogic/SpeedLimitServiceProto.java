package performance.bussinesslogic;

public interface SpeedLimitServiceProto {

    default int getCitySpeedLimit() {
        return 50;
    }

    int getHighwaySpeedLimit();
}
