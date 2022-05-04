package com.aotu.cicd.controller;


import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import com.aotu.cicd.dto.ResponseJson;
import com.aotu.cicd.model.Project;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gavin_wang
 * @since 2022-05-03
 */
@Controller
public class ProjectController {

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("welcome","hello fishpro");
        return "index";
    }
    @RequestMapping("/createProject")
    public String createProject(Model model){
        model.addAttribute("welcome","create project");
        return "create";
    }

    @RequestMapping(value = "/queryProject", method = RequestMethod.POST)
    @ResponseBody
    public String queryProject(){
        ResponseJson responseJson = new ResponseJson();
        List<Project> projectList = ListUtil.list(false);
        Project project = new Project();
        project.setName("wang");
        project.setGroupName("com.demo.wang");
        project.setPackageName("project");
        projectList.add(project);
        return JSONUtil.toJsonStr(projectList);
    }


}
