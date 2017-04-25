package com.shearf.demo.spring.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiahaihu on 17/4/25.
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -8652476103197556829L;

    private Integer id;

    private WebSession session;
}
