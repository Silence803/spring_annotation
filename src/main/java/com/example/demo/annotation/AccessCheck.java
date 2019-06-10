package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * Creat by ZhangXueRong on 2019/6/10
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessCheck {
    int[] value() default {};
}
