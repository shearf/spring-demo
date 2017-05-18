package com.shearf.demo.spring.service;

import com.shearf.demo.spring.domain.entity.Project;

import java.util.List;

/**
 * Created by xiahaihu on 17/5/18.
 */
public interface ProjectService {

    int save(Project project);

    List<Project> listAll();
}
