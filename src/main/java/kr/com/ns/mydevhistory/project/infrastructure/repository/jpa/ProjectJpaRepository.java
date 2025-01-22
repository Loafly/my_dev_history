package kr.com.ns.mydevhistory.project.infrastructure.repository.jpa;

import kr.com.ns.mydevhistory.project.business.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectJpaRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByUserId(Long userId);
}
