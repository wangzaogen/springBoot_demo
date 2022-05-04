package com.aotu.cicd.service;

import com.aotu.cicd.model.Project;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gavin_wang
 * @since 2022-05-03
 */
public interface IProjectService extends IService<Project> {

    PageInfo<Project> selectPageVo(int pageNum, int pageSize);

    Project selectByName(String name);
}
