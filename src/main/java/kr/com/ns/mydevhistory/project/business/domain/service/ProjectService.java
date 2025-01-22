package kr.com.ns.mydevhistory.project.business.domain.service;

import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.business.domain.repository.ProjectRepository;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Page<Project> search(ProjectDto.SearchRequest searchRequest, Pageable pageable) {
        return projectRepository.search(searchRequest, pageable);
    }
}
