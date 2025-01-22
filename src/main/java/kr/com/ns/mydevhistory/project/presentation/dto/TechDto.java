package kr.com.ns.mydevhistory.project.presentation.dto;

import kr.com.ns.mydevhistory.project.business.domain.entity.Tech;

public record TechDto(Short id, String name) {
    public TechDto(Tech tech) {
        this(
                tech.getId(),
                tech.getName()
        );
    }
}
