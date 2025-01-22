package kr.com.ns.mydevhistory.project.business.domain.repository;

import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectRepository {

    Page<Project> search(ProjectDto.SearchRequest searchRequest, Pageable pageable);
}
