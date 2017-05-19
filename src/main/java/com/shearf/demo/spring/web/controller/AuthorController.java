package com.shearf.demo.spring.web.controller;

import com.shearf.demo.spring.component.AuthorComponent;
import com.shearf.demo.spring.domain.Author;
import com.shearf.demo.spring.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xiahaihu2009@gmail on 2017/5/6.
 */
@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;       // 如果不使用proxyTargetClass=true，bean无法创建

    @Autowired
    private AuthorComponent authorComponent;

    @Resource(name = "defaultAuthor")
    private Author defaultAuthor;

    @Value("${author.email}")
    private String email;


    @GetMapping("")
    public String index() {
        authorService.info();
        return email;
    }

    @GetMapping("info")
    public Author info() {
        return authorComponent.author();
    }

    @GetMapping("default")
    public Author defaultAuthor() {
        return defaultAuthor;
    }

}
