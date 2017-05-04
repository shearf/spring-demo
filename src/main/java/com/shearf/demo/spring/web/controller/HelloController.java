package com.shearf.demo.spring.web.controller;

import com.shearf.demo.spring.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiahaihu on 17/4/24.
 */
@RestController
public class HelloController {

    @Autowired
    private Blog defaultBlog;

    @RequestMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("blog")
    public Blog blog() {
        return defaultBlog;
    }
}
