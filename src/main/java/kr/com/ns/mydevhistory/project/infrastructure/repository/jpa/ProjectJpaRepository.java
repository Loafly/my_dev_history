package kr.com.ns.mydevhistory.project.infrastructure.repository.jpa;

import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectJpaRepository extends JpaRepository<Project, Long> {

    @EntityGraph(attributePaths = {"projectTypes", "techs", "projectImages", "projectTaskHistories", "projectPerformances"})
    Optional<Project> findFetchById(Long id);

}
