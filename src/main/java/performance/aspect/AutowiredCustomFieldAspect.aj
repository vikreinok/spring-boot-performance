package performance.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import performance.context.CountryHolder;

import java.lang.reflect.Field;

/**
 * https://stackoverflow.com/questions/56724407/aop-pointcut-for-argument-which-has-a-field-with-annotation
 * https://stackoverflow.com/questions/66563533/how-to-set-a-value-to-a-field-via-aspect
 */
@Aspect
@Component
public aspect AutowiredCustomFieldAspect implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    pointcut annotatedField(): get(@performance.annotation.AutowiredCustom * *);

    before(Object object): annotatedField() && target(object) {
        try {
            String fieldName = thisJoinPoint.getSignature().getName();
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            String className = field.getType().getSimpleName() + CountryHolder.getCountry().name();

            Object bean = applicationContext.getAutowireCapableBeanFactory().getBean(className);

            field.set(object, bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}