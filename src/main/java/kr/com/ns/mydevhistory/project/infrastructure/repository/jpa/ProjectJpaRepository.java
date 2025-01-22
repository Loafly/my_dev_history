package kr.com.ns.mydevhistory.project.infrastructure.repository.jpa;

import kr.com.ns.mydevhistory.project.business.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJpaRepository extends JpaRepository<Project, Long> {
}
