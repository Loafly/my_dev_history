package kr.com.ns.mydevhistory.user.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String description;
    private String profileUrl;

    @Getter
    public static class DetailResponse {
        private String id;
        private String name;
        private String email;
        private String description;
        private String profileUrl;
        private List<UserActivityDto> userActivities;
        private List<UserCareerDto> userCareers;
        private List<UserCertificateDto> userCertificates;
    }
}
