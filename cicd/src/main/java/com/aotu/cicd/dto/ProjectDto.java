package com.aotu.cicd.dto;

import lombok.Data;


/**
 * <p>
 *
 * </p>
 *
 * @author gavin_wang
 * @since 2022-05-03
 */
@Data
public class ProjectDto {

    private Integer id;

    private String name;

    private String groupName;

    private String artifact;

    private String packageName;

    private String packaging;

    private String javaVersion;

    private String bootVersion;

    private String dependencies;
}
