package kr.com.ns.mydevhistory.project.presentation.controller;

import kr.com.ns.mydevhistory.project.business.application.facade.ProjectFacade;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import kr.com.ns.mydevhistory.project.presentation.mapper.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/projects")
@RestController
@RequiredArgsConstructor
public class ProjectControllerImpl implements ProjectControllerDoc {

    private final ProjectFacade projectFacade;
    private final ProjectMapper projectMapper;

    @Override
    @GetMapping("/search")
    public Page<ProjectDto.SearchResponse> search(@ModelAttribute ProjectDto.SearchRequest searchRequest,
                                                  Pageable pageable) {

        return projectFacade.search(searchRequest, pageable)
                .map(projectMapper::toSearchResponseDto);
    }

    @Override
    @GetMapping("/{projectId}")
    public ProjectDto.DetailResponse detail(@PathVariable(name = "projectId") Long id) {

        return projectMapper.toDetailResponseDto(projectFacade.getById(id));
    }


}
