package com.shearf.demo.spring.config;

import com.google.common.collect.Lists;
import com.shearf.demo.spring.event.BlackListNotifier;
import com.shearf.demo.spring.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xiahaihu2009@gmail on 2017/4/27.
 */
@Configuration
public class EventConfig {

    @Bean
    public EmailService emailService() {
        EmailService emailService = new EmailService();
        emailService.setBlackList(
                Lists.newArrayList("test1@test.com", "test2@test.com", "test3@test.com")
        );

        return emailService;
    }

    @Bean
    public BlackListNotifier blackListNotifier() {
        BlackListNotifier blackListNotifier = new BlackListNotifier();
        blackListNotifier.setNotificationAddress("test1@test.com");
        return blackListNotifier;
    }
}
