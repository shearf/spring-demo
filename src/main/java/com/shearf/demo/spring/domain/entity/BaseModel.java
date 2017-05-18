package com.shearf.demo.spring.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiahaihu on 17/5/18.
 */
@Data
abstract class BaseModel implements Serializable {

    private Integer id;

    private Date createdAt;

    private Date updatedAt;
}
