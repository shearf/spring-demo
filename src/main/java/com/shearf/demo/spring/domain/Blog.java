package com.shearf.demo.spring.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by xiahaihu on 17/4/28.
 */
@Data
public class Blog {

    private String title;

    private Date createTime;
}
