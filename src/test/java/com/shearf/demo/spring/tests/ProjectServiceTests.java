package com.shearf.demo.spring.tests;

import com.shearf.demo.spring.config.AppContextConfig;
import com.shearf.demo.spring.domain.entity.Project;
import com.shearf.demo.spring.service.ProjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xiahaihu on 17/5/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContextConfig.class)
public class ProjectServiceTests {

    @Autowired
    private ProjectService projectService;

    @Test
    public void saveTest() {

        Project project = new Project();
        project.setDescription("test");
        project.setName("test");
        project.setRepo("test");
        project.setRepoLink("test.com");
        project.setType("P");
        project.setStatus("V");

        projectService.save(project);
    }
}
