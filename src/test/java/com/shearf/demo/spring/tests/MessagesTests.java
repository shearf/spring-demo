package com.shearf.demo.spring.tests;

import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiahaihu on 17/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppContextConfig.class})
public class MessagesTests {

    @Autowired
    private MessageService messageService;

    @Test
    public void simpleMessageTest() {
        System.out.println(messageService.showEnv());
    }
}
