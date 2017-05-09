package com.shearf.demo.spring.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by xiahaihu on 17/5/9.
 */
public class BeforeUserAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeUserAdvice");
    }
}
