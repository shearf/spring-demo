package com.shearf.demo.spring.config;

import com.shearf.demo.spring.advice.BeforeUserAdvice;
import com.shearf.demo.spring.domain.Author;
import com.shearf.demo.spring.domain.Blog;
import com.shearf.demo.spring.interceptor.DebugInterceptor;
import com.shearf.demo.spring.service.PersonService;
import com.shearf.demo.spring.service.impl.PersonServiceImpl;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
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
@EnableTransactionManagement(proxyTargetClass = true)
@ImportResource(locations = "classpath:beans.xml")
public class AppContextConfig implements EnvironmentAware {

    private Environment environment;

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

    @Bean
    public Author defaultAuthor() {
        Author author = new Author();
        author.setUsername(environment.getProperty("author.username"));
        author.setEmail(environment.getProperty("author.email"));
        return author;
    }

    @Bean
    public FormattingConversionService conversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService(false);

        conversionService.addFormatterForFieldAnnotation(new NumberFormatAnnotationFormatterFactory());

        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
        registrar.registerFormatters(conversionService);

        return conversionService;
    }

    @Bean
    public RegexpMethodPointcutAdvisor userInfoAdvisor() {
        RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
        advisor.setPattern("com.shearf.demo.spring.service.impl.UserServiceImpl.info");
        advisor.setAdvice(new BeforeUserAdvice());
        return advisor;
    }

    @Bean
    public JdkRegexpMethodPointcut userInfoPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern("com.shearf.demo.spring.service.impl.UserServiceImpl.info");
        return pointcut;
    }

    @Bean
    public DefaultPointcutAdvisor userInfoAdvisor2() {
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(userInfoPointcut());
//        advisor.setAdvice(new BeforeUserAdvice());
        advisor.setAdvice(new DebugInterceptor());
        return advisor;
    }

    // Register as default interceptor
//    @Bean
//    public DefaultPointcutAdvisor lockMixinInterceptor() {
//        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
//        advisor.setAdvice(new LockMixin());
//        return advisor;
//    }

    @Bean
    public PersonService personTarget() {
        PersonServiceImpl person = new PersonServiceImpl();
        person.setAge(18);
        person.setName("shearf");
        return person;
    }

    @Bean
    public ProxyFactoryBean person() {

        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(personTarget());
        try {
            proxyFactoryBean.setProxyInterfaces(new Class[]{PersonService.class});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        proxyFactoryBean.setInterceptorNames("debugInterceptor");
        return proxyFactoryBean;
    }



    /*
    public TransactionProxyFactoryBean txProxyTemplate() {
        TransactionProxyFactoryBean factoryBean = new TransactionProxyFactoryBean();
//        factoryBean.setTransactionManager();
        Properties properties = new Properties();
        properties.setProperty("*", "PROPAGATION_REQUIRED");
        factoryBean.setTransactionAttributes(properties);
        return factoryBean;
    }
    */

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * 代替@Autowired private Environment environment
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
