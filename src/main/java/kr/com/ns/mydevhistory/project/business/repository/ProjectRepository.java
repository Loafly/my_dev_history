package kr.com.ns.mydevhistory.project.business.repository;

import kr.com.ns.mydevhistory.project.business.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository {

    List<Project> findAllByUserId(Long userId);

    Page<Project> search(Pageable pageable);
}
