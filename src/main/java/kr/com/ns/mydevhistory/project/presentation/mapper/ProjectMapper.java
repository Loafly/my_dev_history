package kr.com.ns.mydevhistory.project.presentation.mapper;

import kr.com.ns.mydevhistory.common.mapper.BaseMapper;
import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper extends BaseMapper<Project, ProjectDto.DetailResponse> {

    protected ProjectMapper(ModelMapper modelMapper) {
        super(modelMapper, Project.class);
        this.registerDtoMapping(ProjectDto.DetailResponse.class);
        this.registerDtoMapping(ProjectDto.SearchResponse.class);
    }

    public ProjectDto.SearchResponse toSearchResponseDto(Project project) {
        return toDto(project, ProjectDto.SearchResponse.class);
    }

    public ProjectDto.DetailResponse toDetailResponseDto(Project project) {
        return toDto(project, ProjectDto.DetailResponse.class);
    }
}
