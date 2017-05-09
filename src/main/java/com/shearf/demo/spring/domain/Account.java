package com.shearf.demo.spring.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Created by xiahaihu on 17/5/8.
 */
@Data
//@Configurable
public class Account {

    private Integer id;

    private String name;
}
