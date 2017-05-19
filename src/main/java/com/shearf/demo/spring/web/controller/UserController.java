package com.shearf.demo.spring.web.controller;

import com.shearf.demo.spring.domain.User;
import com.shearf.demo.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xiahaihu on 17/4/25.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("current")
    public User getUserInfo() {
        return userService.info(1);
    }
}
