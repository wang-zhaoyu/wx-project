package com.wangzhaoyu.aspect.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
//当子类继承父类时候，方法和类名上自定义注解可被继承
@Retention(RetentionPolicy.RUNTIME)
//通过反射可以被拿到注解
@Target({ ElementType.FIELD, ElementType.METHOD })
//注解可以存放的位置，方法和属性上
@Documented
public @interface LogAspect {
	
	String value() default "";
	
}
