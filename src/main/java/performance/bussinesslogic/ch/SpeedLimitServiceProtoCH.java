package performance.bussinesslogic.ch;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import performance.bussinesslogic.SpeedLimitServiceProto;
import performance.contition.CountryCH;

//@Scope(value = org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST)
@Service
@Conditional(CountryCH.class)
public class SpeedLimitServiceProtoCH implements SpeedLimitServiceProto {

    @Override
    public int getHighwaySpeedLimit() {
        return 120;
    }
}
