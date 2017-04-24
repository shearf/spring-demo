package com.shearf.demo.spring;

import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.domain.Author;
import com.shearf.demo.spring.domain.Info;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xiahaihu on 17/4/21.
 */
public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppContextConfig.class);

        Author author = applicationContext.getBean(Author.class);
        Info info = applicationContext.getBean(Info.class);
        System.out.println(author.getEmail());
        System.out.println(info.getEnv());
        System.out.println(info.getVersion());
    }

}
