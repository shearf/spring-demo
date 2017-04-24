package com.shearf.demo.spring.domain;

import lombok.Data;

/**
 * Created by xiahaihu on 17/4/21.
 */
@Data
public class Author {

    private String username;

    private String email;

    public void init() {
        System.out.println("Author init");
    }
}
