package com.aotu.cicd.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author gavin_wang
 * @since 2022-05-03
 */
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String groupName;

    private String artifact;

    private String packageName;

    private String packaging;

    private String javaVersion;

    private String bootVersion;

    private String dependencies;

    private LocalDateTime createTime;

    private String creater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }


    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }
    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }
    public String getBootVersion() {
        return bootVersion;
    }

    public void setBootVersion(String bootVersion) {
        this.bootVersion = bootVersion;
    }
    public String getDependencies() {
        return dependencies;
    }

    public void setDependencies(String dependencies) {
        this.dependencies = dependencies;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    @Override
    public String toString() {
        return "Project{" +
            "id=" + id +
            ", name=" + name +
            ", groupName=" + groupName +
            ", artifact=" + artifact +
            ", packageName=" + packageName +
            ", packaging=" + packaging +
            ", javaVersion=" + javaVersion +
            ", bootVersion=" + bootVersion +
            ", dependencies=" + dependencies +
            ", createTime=" + createTime +
            ", creater=" + creater +
        "}";
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
