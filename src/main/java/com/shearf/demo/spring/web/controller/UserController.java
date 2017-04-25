package com.shearf.demo.spring.web.controller;

import com.shearf.demo.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiahaihu on 17/4/25.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private User user;

    @GetMapping("current")
    public User getUserInfo() {
        return user;
    }
}
