package kr.com.ns.mydevhistory.project.business.service;

import kr.com.ns.mydevhistory.project.business.entity.Project;
import kr.com.ns.mydevhistory.project.business.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> getAllByUserId(Long userId) {
        return projectRepository.findAllByUserId(userId);
    }
}
