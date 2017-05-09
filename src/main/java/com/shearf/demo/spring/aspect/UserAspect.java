package com.shearf.demo.spring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * Created by xiahaihu on 17/4/28.
 */
@Aspect
@Component
public class UserAspect {

//    @Pointcut(value = "execution(* com.shearf.demo.spring.service.UserService.info(id))", argNames = "id")
    @Pointcut(value = "execution(* com.shearf.demo.spring.service.impl.UserServiceImpl.info(..)) && args(id))")
    public void test(int id) {
        System.out.println(id);
    }

    @Before(value = "test(id)", argNames = "id")
    public void before(int id) {
        System.out.println("Called UserService info before, args:" + id);
    }

}
