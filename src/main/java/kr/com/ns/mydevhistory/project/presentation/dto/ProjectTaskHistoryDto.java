package kr.com.ns.mydevhistory.project.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectTaskHistoryDto {
    private Short id;
    private Long projectId;
    private String content;
    private short orderIndex;
}
