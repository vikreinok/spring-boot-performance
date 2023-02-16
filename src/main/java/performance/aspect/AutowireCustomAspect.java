package performance.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AutowireCustomAspect {

    @Around("@annotation(performance.annotation.AutowiredCustom)")
    public Object onlyAutowiredCustom(final ProceedingJoinPoint pjp) throws Throwable {
        //do some stuff before invoking methods annotated with @AutowireCustom
        final Object returnValue = pjp.proceed();
        final String declaringTypeName = pjp.getSignature().getDeclaringTypeName();
        System.err.println("Declaring type name: " + declaringTypeName);
        //do some stuff after invoking methods annotated with @AutowireCustom
        return returnValue;
    }
}