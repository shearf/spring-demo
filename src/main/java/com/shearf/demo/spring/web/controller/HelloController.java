package com.shearf.demo.spring.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiahaihu on 17/4/24.
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "Hello World";
    }
}
