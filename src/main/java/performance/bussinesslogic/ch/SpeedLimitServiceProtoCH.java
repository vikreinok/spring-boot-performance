package performance.bussinesslogic.ch;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import performance.bussinesslogic.SpeedLimitServiceProto;
import performance.contition.CountryCH;

@Service
@Scope(value = org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
@Conditional(CountryCH.class)
public class SpeedLimitServiceProtoCH implements SpeedLimitServiceProto {

    @Override
    public int getHighwaySpeedLimit() {
        return 120;
    }
}
