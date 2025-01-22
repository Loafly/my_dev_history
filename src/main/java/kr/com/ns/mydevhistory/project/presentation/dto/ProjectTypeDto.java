package kr.com.ns.mydevhistory.project.presentation.dto;

import kr.com.ns.mydevhistory.project.business.domain.entity.ProjectType;

public record ProjectTypeDto(Short id, String name) {
    public ProjectTypeDto(ProjectType projectType) {
        this(
                projectType.getId(),
                projectType.getName()
        );
    }
}
