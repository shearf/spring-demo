package com.shearf.demo.spring.web.controller;

import com.shearf.demo.spring.domain.param.SearchParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiahaihu on 17/5/4.
 */
@RestController
public class SearchController {

    @RequestMapping("search")
    public SearchParam searchParam(SearchParam searchParam) {
        return searchParam;
    }
}
