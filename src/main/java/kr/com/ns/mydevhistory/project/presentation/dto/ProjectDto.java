package kr.com.ns.mydevhistory.project.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class ProjectDto {

    @Getter
    @NoArgsConstructor
    public static class SearchResponse {
        private long id;
        private long userId;
        private String name;
        private String description;
        private LocalDate startDate;
        private LocalDate endDate;
        private String thumbnailUrl;
        private List<ProjectTypeDto> projectTypes;
        private List<TechDto> techs;
    }

    public record SearchRequest(Long userId,
                                String projectTypeName,
                                String techName) { }

    @Getter
    @NoArgsConstructor
    public static class DetailResponse {
        private long id;
        private long userId;
        private String name;
        private String description;
        private LocalDate startDate;
        private LocalDate endDate;
        private String thumbnailUrl;
        private long personnel;
        private List<ProjectTypeDto> projectTypes;
        private List<TechDto> techs;
        private List<ProjectImageDto> projectImages;
        private List<ProjectTaskHistoryDto> projectTaskHistories;
        private List<ProjectPerformanceDto> projectPerformances;
        private List<ProjectTroubleshootingDto> projectTroubleshootings;

    }
}
