package com.shearf.demo.spring.service.impl;

import com.shearf.demo.spring.dal.mapper.ProjectMapper;
import com.shearf.demo.spring.domain.entity.Project;
import com.shearf.demo.spring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xiahaihu on 17/5/18.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    @Transactional
    public int save(Project project) {
        return projectMapper.insertSelective(project);
    }

    @Override
    public List<Project> listAll() {
        return projectMapper.selectAll();
    }
}
