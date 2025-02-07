package kr.com.ns.mydevhistory.project.presentation.mapper;

import kr.com.ns.mydevhistory.common.mapper.BaseMapper;
import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectDetailResponseMapper extends BaseMapper<Project, ProjectDto.DetailResponse> {

    protected ProjectDetailResponseMapper(ModelMapper modelMapper) {
        super(modelMapper, Project.class, ProjectDto.DetailResponse.class);
    }

    public ProjectDto.DetailResponse toSearchResponseDto(Project project) {
        return toDto(project);
    }
}
