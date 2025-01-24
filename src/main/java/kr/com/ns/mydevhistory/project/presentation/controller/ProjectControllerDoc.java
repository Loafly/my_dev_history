package kr.com.ns.mydevhistory.project.presentation.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Tag(name = "Project", description = "Project management APIs")
public interface ProjectControllerDoc {

    Page<ProjectDto.SearchResponse> search(
            @ParameterObject ProjectDto.SearchRequest searchRequest,
            @ParameterObject Pageable pageable);


}
