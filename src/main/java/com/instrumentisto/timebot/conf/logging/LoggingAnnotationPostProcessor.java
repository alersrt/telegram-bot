package com.instrumentisto.timebot.conf.logging;

import java.lang.reflect.Field;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link BeanPostProcessor} for {@link Logging} annotation.
 */
@Component
public class LoggingAnnotationPostProcessor implements BeanPostProcessor {

    /**
     * Implementation of {@code Object postProcessBeforeInitialization(
     * Object bean, String beanName)}
     * {@link BeanPostProcessor}'s method.
     *
     * @param bean {@link org.slf4j.Logger} bean.
     * @param beanName name of returned bean.
     * @return {@link org.slf4j.Logger} object.
     * @throws BeansException exception which will can returned.
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
        Class aClass = bean.getClass();

        do {
            for (Field field : aClass.getDeclaredFields()) {
                Logging annotation = field.getAnnotation(Logging.class);

                if (annotation != null) {
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    try {
                        if (!annotation.value().isEmpty()) {
                            field.set(bean, LoggerFactory.getLogger(
                                annotation.value()));
                        } else {
                            field.set(bean, LoggerFactory.getLogger(aClass));
                        }
                    } catch (IllegalAccessException e) {
                        LoggerFactory.getLogger(
                            this.getClass()).error(e.getMessage(), e);
                    }
                    field.setAccessible(accessible);
                }
            }
            aClass = aClass.getSuperclass();
        } while (aClass != null);

        return bean;
    }

    /**
     * Implementation of {@code Object postProcessAfterInitialization(
     * Object bean, String beanName)}
     * {@link BeanPostProcessor}'s method.
     *
     * @param bean {@link org.slf4j.Logger} bean.
     * @param beanName name of returned bean.
     * @return {@link org.slf4j.Logger} object.
     * @throws BeansException exception which will can returned.
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
        throws BeansException {
        return bean;
    }
}
