package kr.com.ns.mydevhistory.project.business.facade;

import kr.com.ns.mydevhistory.common.annotation.Facade;
import kr.com.ns.mydevhistory.project.business.entity.Project;
import kr.com.ns.mydevhistory.project.business.service.ProjectService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Facade
@RequiredArgsConstructor
public class ProjectFacade {

    private final ProjectService projectService;

    // 프로젝트 정보 조회
    public List<Project> getAllByUserId(Long userId) {
        return projectService.getAllByUserId(userId);
    }


}
