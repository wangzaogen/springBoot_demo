package com.aotu.cicd.service.impl;

import com.aotu.cicd.model.Project;
import com.aotu.cicd.mapper.ProjectMapper;
import com.aotu.cicd.service.IProjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gavin_wang
 * @since 2022-05-03
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public PageInfo<Project> selectPageVo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Project> pageInfo = new PageInfo<>(projectMapper.selectPageVo());
        return pageInfo;
    }

    @Override
    public Project selectByName(String name) {
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        return projectMapper.selectOne(queryWrapper);
    }
}
