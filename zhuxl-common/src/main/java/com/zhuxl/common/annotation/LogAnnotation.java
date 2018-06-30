package com.zhuxl.common.annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface LogAnnotation {
    String action() default "";

    String data() default "";

    int level() default 1;

}
