package com.shearf.demo.spring.config;

import com.shearf.demo.spring.domain.User;
import com.shearf.demo.spring.domain.WebSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Random;

/**
 * Created by xiahaihu on 17/4/25.
 */
@Configuration
public class SessionConfig {

    @Autowired
    private Environment environment;

    @Bean
    @RequestScope
    public WebSession webSession() {
        WebSession webSession = new WebSession();
        webSession.setId((new Random()).nextInt());
        return webSession;
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1);
        user.setSession(webSession());
        return user;
    }
}
