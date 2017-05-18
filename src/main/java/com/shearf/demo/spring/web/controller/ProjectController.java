package com.shearf.demo.spring.web.controller;

import com.shearf.demo.spring.domain.entity.Project;
import com.shearf.demo.spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xiahaihu on 17/5/18.
 */
@RestController
@RequestMapping("project")
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    @ResponseBody
    public List<Project> list() {
        return projectService.listAll();
    }
}
