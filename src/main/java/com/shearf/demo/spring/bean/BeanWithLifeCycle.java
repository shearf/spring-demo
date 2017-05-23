package com.shearf.demo.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by xiahaihu on 17/5/23.
 */
@Component
public class BeanWithLifeCycle implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanWithLifeCycle afterPropertiesSet");
    }

    @PostConstruct
    public void PostConstruct() {
        System.out.println("BeanWithLifeCycle @PostConstruct");
    }

    @PreDestroy
    public void preDestory() {
        System.out.println();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanWithLifeCycle destory");
    }
}
