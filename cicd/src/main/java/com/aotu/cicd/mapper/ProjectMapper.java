package com.aotu.cicd.mapper;

import com.aotu.cicd.model.Project;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gavin_wang
 * @since 2022-05-03
 */
public interface ProjectMapper extends BaseMapper<Project> {

    List<Project> selectPageVo();

}
