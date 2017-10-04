package com.instrumentisto.timebot.conf.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/**
 * Annotation for getting of Logger instance for logging application.
 */
public @interface Logging {

    String value() default "";
}
