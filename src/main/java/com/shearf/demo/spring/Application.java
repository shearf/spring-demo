package com.shearf.demo.spring;

import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.domain.Author;
import com.shearf.demo.spring.domain.Blog;
import com.shearf.demo.spring.domain.Info;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xiahaihu on 17/4/21.
 */
public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("test");
        applicationContext.register(AppContextConfig.class);
        applicationContext.refresh();


        Author author = applicationContext.getBean(Author.class);
        Info info = (Info) applicationContext.getBean("envInfo");

        Blog blog = (Blog) applicationContext.getBean("defaultBlog");
        System.out.println(blog.getCreateTime());

        System.out.println(author.getEmail());
        System.out.println(info.getEnv());
        System.out.println(info.getVersion());

    }

}
