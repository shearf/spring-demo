package com.shearf.demo.spring.service.impl;

import com.shearf.demo.spring.service.UserIntroduction;
import org.springframework.stereotype.Service;

/**
 * Created by xiahaihu2009@gmail on 2017/5/7.
 */
@Service
public class UserIntroductionImpl implements UserIntroduction {
    @Override
    public void userServiceCalled() {
        System.out.println("Service userService called");
    }
}
