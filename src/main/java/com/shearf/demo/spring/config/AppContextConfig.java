package com.shearf.demo.spring.config;

import com.shearf.demo.spring.domain.Author;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by xiahaihu on 17/4/21.
 */
@Configuration
@ComponentScan(basePackages = "com.shearf.demo.spring", excludeFilters = @ComponentScan.Filter(
        classes = {EnableWebMvc.class}
))
@PropertySource("classpath:application.properties")
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class AppContextConfig {

    @Value("${author.username}")
    private String username;

    @Value("${author.email}")
    private String email;

    @Bean(initMethod = "init")
    public Author author() {
        Author author = new Author();
        author.setUsername(username);
        author.setEmail(email);
        return author;
    }
}
