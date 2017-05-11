package com.shearf.demo.spring.tests;

import com.shearf.demo.spring.component.ProtectedMethodComponent;
import com.shearf.demo.spring.config.AppContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiahaihu2009@gmail on 2017/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class PointcutTests {

    @Autowired
    private ProtectedMethodComponent protectedMethodComponent;

    @Test
    public void protectedMethodCalled() {
//        ProtectedMethodComponent protectedMethodComponent = new ProtectedMethodComponent();
        protectedMethodComponent.invoke();
    }
}
