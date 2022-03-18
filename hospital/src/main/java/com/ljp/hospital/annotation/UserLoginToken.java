package com.ljp.hospital.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 用户登录后才能操作
 * @author ljp
 * */
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface UserLoginToken {
    boolean required() default true;
}
