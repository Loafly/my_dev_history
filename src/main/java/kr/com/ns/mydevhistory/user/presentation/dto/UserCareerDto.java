package kr.com.ns.mydevhistory.user.presentation.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserCareerDto {
    private long id;
    private long userId;
    private short orderIndex;
    private String companyName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
}
