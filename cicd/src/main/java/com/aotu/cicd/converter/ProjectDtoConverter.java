package com.aotu.cicd.converter;

import com.aotu.cicd.dto.ProjectDto;
import com.aotu.cicd.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectDtoConverter {

    ProjectDtoConverter INSTANCE = Mappers.getMapper(ProjectDtoConverter.class);

    Project toProject(ProjectDto dto);
}
