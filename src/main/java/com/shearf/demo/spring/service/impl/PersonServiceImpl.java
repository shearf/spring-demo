package com.shearf.demo.spring.service.impl;

import com.shearf.demo.spring.service.PersonService;

/**
 * Created by xiahaihu on 17/5/15.
 */
public class PersonServiceImpl implements PersonService {

    private String name;

    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }
}
