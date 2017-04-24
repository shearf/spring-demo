package com.shearf.demo.spring.config;

import com.shearf.demo.spring.domain.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by xiahaihu on 17/4/21.
 */
@Configuration
@PropertySource("classpath:info-${env}.properties")
public class InfoConfiguration {

    @Value("${info.env}")
    private String env;

    @Value("${info.version}")
    private String version;

    @Bean
    public Info info() {
        Info info = new Info();
        info.setEnv(env);
        info.setVersion(version);
        return info;
    }
}
