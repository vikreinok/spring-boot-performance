package performance.aspect;


import org.aspectj.lang.annotation.Aspect;
import performance.bussinesslogic.ch.SpeedLimitServiceDE;

import java.lang.reflect.Field;

/**
 * https://stackoverflow.com/questions/56724407/aop-pointcut-for-argument-which-has-a-field-with-annotation
 * https://stackoverflow.com/questions/66563533/how-to-set-a-value-to-a-field-via-aspect
 */
@Aspect
public privileged aspect AutowiredCustomFieldAspect {

    pointcut annotatedField(): get(@performance.annotation.AutowiredCustom * *);

    before(Object object): annotatedField() && target(object) {
        try {
            String fieldName = thisJoinPoint.getSignature().getName();
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, new SpeedLimitServiceDE());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}