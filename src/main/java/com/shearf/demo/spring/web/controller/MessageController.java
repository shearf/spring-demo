package com.shearf.demo.spring.web.controller;

import com.shearf.demo.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiahaihu on 17/4/26.
 */
@RestController
@RequestMapping("msg")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("env")
    public String env() {
        return messageService.showEnv();
    }
}
