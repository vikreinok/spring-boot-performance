package performance.bussinesslogic.ch;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import performance.bussinesslogic.SpeedLimitServiceProto;
import performance.contition.CountryDE;

//@Scope(value = org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
@Service
@Conditional(CountryDE.class)
public class SpeedLimitServiceProtoDE implements SpeedLimitServiceProto {

    @Override
    public int getHighwaySpeedLimit() {
        return 200;
    }
}
