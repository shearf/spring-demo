package com.shearf.demo.spring.web.controller;

import com.shearf.demo.spring.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiahaihu2009@gmail on 2017/4/27.
 */
@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("email")
    public String sendEmail() {

        emailService.sendEmail("test1@test.com","test1");
        return "Send Email";
    }
}
