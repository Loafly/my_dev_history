package kr.com.ns.mydevhistory.project.presentation.dto;

import kr.com.ns.mydevhistory.project.business.domain.entity.Project;

import java.time.LocalDate;
import java.util.List;

public class ProjectDto {

    public record SearchResponse(long id,
                                 long userId,
                                 String name,
                                 LocalDate startDate,
                                 LocalDate endDate,
                                 String thumbnailUrl,
                                 List<ProjectTypeDto> projectTypes,
                                 List<TechDto> techs
    ) {

         public SearchResponse(Project project) {
            this(
                    project.getId(),
                    project.getUserId(),
                    project.getName(),
                    project.getStartDate(),
                    project.getEndDate(),
                    project.getThumbnailUrl(),
                    project.getProjectTypes().stream().map(ProjectTypeDto::new).toList(),
                    project.getTechs().stream().map(TechDto::new).toList()
            );
        }
    }

    public record SearchRequest(Long userId,
                                String projectTypeName,
                                String techName) { }
}
