package kr.com.ns.mydevhistory.project.infrastructure.repository;

import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import kr.com.ns.mydevhistory.project.business.domain.repository.ProjectRepository;
import kr.com.ns.mydevhistory.project.infrastructure.repository.jpa.ProjectJpaRepository;
import kr.com.ns.mydevhistory.project.infrastructure.repository.querydsl.ProjectQueryRepository;
import kr.com.ns.mydevhistory.project.presentation.dto.ProjectDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private final ProjectJpaRepository projectJpaRepository;
    private final ProjectQueryRepository projectQueryRepository;

    // QueryDSL을 활용하여 구현
    @Override
    public Page<Project> search(ProjectDto.SearchRequest searchRequest, Pageable pageable) {

        return projectQueryRepository.search(searchRequest, pageable);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectJpaRepository.findById(id);
    }
}
