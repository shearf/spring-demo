package com.shearf.demo.spring.dal.mapper;

import com.shearf.demo.spring.domain.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiahaihu on 17/5/18.
 */
@Repository
public interface ProjectMapper {

    List<Project> selectAll();

    int insertSelective(Project project);

}
