package kr.com.ns.mydevhistory.project.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectImageDto {
    private Short id;
    private String imageUrl;
    private Long projectId;

}
