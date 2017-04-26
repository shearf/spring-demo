package com.shearf.demo.spring.service.impl;

import com.shearf.demo.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * Created by xiahaihu on 17/4/25.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String showEnv() {
        return messageSource.getMessage("env.dev", null, "default", null);
    }
}
