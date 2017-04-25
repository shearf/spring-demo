package com.shearf.demo.spring;

import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.EnumSet;

/**
 * Created by xiahaihu on 17/4/24.
 */
public class SpringWebDemoApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext context) throws ServletException {
        //配置Spring提供的字符编码过滤器
        javax.servlet.FilterRegistration.Dynamic filter = context.addFilter("encoding", new CharacterEncodingFilter());
        //配置过滤器的过滤路径
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/");

        //基于注解配置的Spring容器上下文
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        //注册Spring容器配置类
        rootContext.register(AppContextConfig.class);
        context.addListener(new ContextLoaderListener(rootContext));
        //SQL配置文件监听器
//        container.addListener(new SQLMappingInitListener());

        //基于注解配置的Web容器上下文
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        //注册Web容器配置类
        webContext.register(WebConfig.class);
        ServletRegistration.Dynamic servlet = context.addServlet("dispatcher", new DispatcherServlet(webContext));
        //配置映射路径
        servlet.addMapping("/");
        //启动顺序
        servlet.setLoadOnStartup(1);
    }
}
