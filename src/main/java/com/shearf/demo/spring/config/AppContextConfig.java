package com.shearf.demo.spring.config;

import com.shearf.demo.spring.domain.Author;
import com.shearf.demo.spring.domain.Blog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.number.NumberFormatAnnotationFormatterFactory;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;

/**
 * Created by xiahaihu on 17/4/21.
 */
@Configuration
@ComponentScan(basePackages = "com.shearf.demo.spring", excludeFilters = @ComponentScan.Filter(
        classes = {EnableWebMvc.class}
))
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
public class AppContextConfig implements EnvironmentAware {

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

    @Override
    public void setEnvironment(Environment environment) {
    }


    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasenames("message");
//        messageSource.setBasenames(
//                "classpath:messages/info",
//                "classpath:messages/user"
//        );
        return messageSource;
    }

    @Bean
    public Blog defaultBlog() {
        Blog blog = new Blog();
        blog.setCreateTime(new Date());
        blog.setTitle("Default Blog For Test");
        return blog;
    }

}
