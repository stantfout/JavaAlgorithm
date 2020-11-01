package com.usth.annotation;

import java.lang.annotation.*;

/**
 * 好题
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface GoodQuestion {
    String value() default "";
}
