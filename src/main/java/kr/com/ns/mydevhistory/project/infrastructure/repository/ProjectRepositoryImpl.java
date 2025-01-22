package kr.com.ns.mydevhistory.project.infrastructure.repository;

import kr.com.ns.mydevhistory.project.business.entity.Project;
import kr.com.ns.mydevhistory.project.business.repository.ProjectRepository;
import kr.com.ns.mydevhistory.project.infrastructure.repository.jpa.ProjectJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ProjectRepositoryImpl implements ProjectRepository {

    private final ProjectJpaRepository projectJpaRepository;
    private final ProjectQueryRepository projectQueryRepository;

    // JPA를 활용하여 구현
    @Override
    public List<Project> findAllByUserId(Long userId) {
        return projectJpaRepository.findAllByUserId(userId);
    }

    // QueryDSL을 활용하여 구현
    @Override
    public Page<Project> search(Pageable pageable) {
        return projectQueryRepository.search(pageable);
    }
}
