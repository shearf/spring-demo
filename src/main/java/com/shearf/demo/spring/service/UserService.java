package com.shearf.demo.spring.service;

import com.shearf.demo.spring.domain.User;

/**
 * Created by xiahaihu on 17/4/28.
 */
public interface UserService {

    User info();

    User info(int id);
}
