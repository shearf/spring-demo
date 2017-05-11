package com.shearf.demo.spring.service.impl;

import com.shearf.demo.spring.domain.User;
import com.shearf.demo.spring.service.AuthorService;
import com.shearf.demo.spring.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by xiahaihu2009@gmail on 2017/5/6.
 */
@Service
public class AuthorServiceImpl implements AuthorService, UserService {
    @Override
    public String description() {
        return null;
    }

    @Override
    public User info() {
        return null;
    }

    @Override
    public User info(int id) {
        return null;
    }
}
