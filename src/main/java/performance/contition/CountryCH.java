package performance.contition;

import performance.Country;
import performance.context.CountryHolder;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CountryCH implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return CountryHolder.getCountry() == Country.CH;
    }

}
