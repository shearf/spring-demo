package com.shearf.demo.spring.service.impl;

import com.shearf.demo.spring.domain.User;
import com.shearf.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiahaihu on 17/4/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private User user;


    @Override
    public User info() {
        return user;
    }

    @Override
    public User info(int id) {
        return user;
    }
}
