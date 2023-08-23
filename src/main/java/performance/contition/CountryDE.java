package performance.contition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import performance.Country;
import performance.context.CountryHolder;

public class CountryDE implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return CountryHolder.getCountry() == Country.DE;
    }

}
