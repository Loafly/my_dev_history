package kr.com.ns.mydevhistory.project.business.domain.repository;

import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProjectRepository {

    Page<Project> search(ProjectDto.SearchRequest searchRequest, Pageable pageable);

    Optional<Project> findFetchById(Long id);
}
