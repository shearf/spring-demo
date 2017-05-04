package com.shearf.demo.spring.domain.param;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiahaihu on 17/5/4.
 */
@Data
public class SearchParam implements Serializable {
    private static final long serialVersionUID = -5613092513113713770L;

    private Boolean enable;

    private String title;
}
