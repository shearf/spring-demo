package com.shearf.demo.spring.tests;

import com.shearf.demo.spring.config.AppContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;

/**
 * Created by xiahaihu on 17/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class ProxyFactoryTests {

    @Test
    public void beforeUserInfoTest() {

        ProxyFactory factory = new ProxyFactory(new SimplePojoImpl());
        factory.addInterface(SimplePojo.class);
        factory.addAdvice(new BeforeMethod());
        SimplePojo simplePojo = (SimplePojo) factory.getProxy();
        simplePojo.foo();

    }



    interface SimplePojo {
        void foo();
    }

    class SimplePojoImpl implements SimplePojo {

        @Override
        public void foo() {
            System.out.println("foo()");
        }
    }

    class BeforeMethod implements MethodBeforeAdvice {

        @Override
        public void before(Method method, Object[] args, Object target) throws Throwable {
            System.out.println("Before ");
        }
    }
}
