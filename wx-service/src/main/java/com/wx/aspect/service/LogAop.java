package com.wx.aspect.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogAop{

	@Before("@annotation(com.wangzhaoyu.aspect.api.LogAspect)")
	public void before() {
		System.out.println("调用方法之前调用......");
	}
	@Around("@annotation(com.wangzhaoyu.aspect.api.LogAspect)")
	public Object around(ProceedingJoinPoint joinPoint) throws Exception {
		System.out.println("调用方法前后都调用......");
		try {
            return joinPoint.proceed();
        } catch (Throwable e) {
        	e.printStackTrace();
        	throw new Exception("what ......");
        }
	}
}
