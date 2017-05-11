package com.shearf.demo.spring.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by xiahaihu2009@gmail on 2017/5/6.
 */
@Aspect
@Component
public class ProtectedMethodPointCut {

    @Pointcut("target(com.shearf.demo.spring.component.ProtectedMethodComponent)")
    public void invoke() {

    }

    @Before("invoke()")
    public void beforeInvoke() {
        System.out.println("pointcut before invoke");
    }

    @AfterReturning(value = "invoke()", returning = "ex")
    public void invokeThrowing(Exception ex) {

    }

    @After("execution(* com.shearf.demo.spring.component.ProtectedMethodComponent.invoke())")
    public void afterInvoke() {
        System.out.println("pointcut after invoke");
    }
}
