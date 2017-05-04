package com.shearf.demo.spring.domain;

import lombok.Data;

/**
 * Created by xiahaihu on 17/4/28.
 */
@Data
public class Customer {

    private String firstName;

    private String lastName;

    private Address address;
}
