package com.shearf.demo.spring.domain.entity;

import lombok.Data;

/**
 * Created by xiahaihu on 17/5/18.
 */
@Data
public class Project extends BaseModel {

    private String name;

    private String type;

    private String description;

    private String repo;

    private String repoLink;

    private String status;
}
