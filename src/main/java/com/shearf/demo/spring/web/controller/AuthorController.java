package com.shearf.demo.spring.web.controller;

import com.shearf.demo.spring.service.UserService;
import com.shearf.demo.spring.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiahaihu2009@gmail on 2017/5/6.
 */
@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;       // 如果不使用proxyTargetClass=true，bean无法创建


    @GetMapping("")
    public String index() {
        authorService.info();

        System.out.println(authorService instanceof UserService);
        return "index";
    }
}
