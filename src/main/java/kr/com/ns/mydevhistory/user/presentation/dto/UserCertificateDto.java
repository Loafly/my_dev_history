package kr.com.ns.mydevhistory.user.presentation.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserCertificateDto {
    private long id;
    private long userId;
    private short orderIndex;
    private String name;
    private LocalDate acquisitionDate;
    private String description;
}
