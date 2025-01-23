package kr.com.ns.mydevhistory.project.presentation.mapper;

import kr.com.ns.mydevhistory.common.mapper.BaseMapper;
import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper extends BaseMapper<Project, ProjectDto.SearchResponse> {

    protected ProjectMapper(ModelMapper modelMapper) {
        super(modelMapper, Project.class, ProjectDto.SearchResponse.class);
    }

    public ProjectDto.SearchResponse toSearchResponseDto(Project project) {
        return toDto(project);
    }
}
