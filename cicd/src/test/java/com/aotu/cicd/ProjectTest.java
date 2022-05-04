package com.aotu.cicd;

import cn.hutool.json.JSONUtil;
import com.aotu.cicd.converter.ProjectDtoConverter;
import com.aotu.cicd.dto.ProjectDto;
import com.aotu.cicd.model.Project;
import com.aotu.cicd.service.IProjectService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProjectTest {

    @Autowired
    private IProjectService projectService;

    @Test
    public void queryProjectTest() {
        Project project =  projectService.getById(1);
        log.info(JSONUtil.toJsonStr(project));
    }

    @Test
    public void queryPageTest() {
        PageInfo<Project> selectPageVo = projectService.selectPageVo(1, 10);
        log.info(JSONUtil.toJsonStr(selectPageVo));
    }

    @Test
    public void queryBynameTest() {
        Project project =  projectService.selectByName("111");
        log.info(JSONUtil.toJsonStr(project));
    }

    @Test
    public void dtoChangeTest() {
        ProjectDto dto = new ProjectDto();
        dto.setName("wang");
        dto.setGroupName("3234");

       Project project = ProjectDtoConverter.INSTANCE.toProject(dto);
       log.info(JSONUtil.toJsonStr(project));
    }
}
