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
    public int save(Project project) {
        return projectMapper.insertSelective(project);
    }

    @Override
    public List<Project> listAll() {
        return projectMapper.selectAll();
    }

    @Override
    @Transactional
    public int insertBatch(List<Project> projects) {

        int result = 0;
        for (Project project : projects) {
            result += projectMapper.insertSelective(project);
        }
        return result;
    }

    @Override
    @Transactional
    public int proxyInsertBatch(List<Project> projects) {

        try {
            this.insertBatch(projects);
        } catch (Exception e) {
        }

        Project project = projects.get(0);
        project.setId(project.getId() + 10);
        project.setName("test1");

        save(project);
        return 0;
    }
}
