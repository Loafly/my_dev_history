package kr.com.ns.mydevhistory.project.business.application.facade;

import kr.com.ns.mydevhistory.common.annotation.Facade;
import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.business.domain.service.ProjectService;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Facade
@RequiredArgsConstructor
public class ProjectFacade {

    private final ProjectService projectService;

    // 프로젝트 정보 조회
    @Transactional(readOnly = true)
    public Page<Project> search(ProjectDto.SearchRequest searchRequest, Pageable pageable) {
        return projectService.search(searchRequest, pageable);
    }


}
