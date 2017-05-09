package com.shearf.demo.spring.tests;

import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by xiahaihu on 17/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class BeansTests {

    @Autowired
    private Account defaultAccount;

    @Autowired
    private Account otherAccount;

    @Test
    public void configurableBeanTest() {
//        Account account = new Account();
        System.out.println(defaultAccount.getName());

        System.out.println(otherAccount.getName());
    }
}
