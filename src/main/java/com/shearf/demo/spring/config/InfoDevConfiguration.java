package com.shearf.demo.spring.config;

import com.shearf.demo.spring.domain.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by xiahaihu on 17/4/21.
 */
//@Configuration
@Profile("dev")
@PropertySource("classpath:info-dev.properties")
public class InfoDevConfiguration {

    @Autowired
    private Environment environment;

    @Value("${info.env}")
    private String env;

    @Value("${info.version}")
    private String version;

    @Bean
    public Info envInfo() {
        Info info = new Info();
        info.setEnv(environment.getProperty("info.env"));
        info.setVersion(environment.getProperty("info.version"));
        return info;
    }
}
