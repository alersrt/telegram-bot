package com.instrumentisto.timebot.conf.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for getting of Logger instance for logging application.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {

    /**
     * Construction which determines value of field on which {@link Logging}
     * annotation will placed.
     *
     * @return {@link String} value.
     */
    String value() default "";
}
