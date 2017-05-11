package com.shearf.demo.spring.aspect;

import com.shearf.demo.spring.service.UserIntroduction;
import com.shearf.demo.spring.service.impl.UserIntroductionImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xiahaihu2009@gmail on 2017/5/7.
 */
@Component
@Aspect
public class UserIntroductionAspect {

    @DeclareParents(value = "com.shearf.demo.spring.service.UserService", defaultImpl = UserIntroductionImpl.class)
    @Autowired
    private UserIntroduction userIntroduction;

    @Before("com.shearf.demo.spring.aspect.UserAspect.interfaceTarget()")
    public void call() {
        userIntroduction.userServiceCalled();
    }
}
