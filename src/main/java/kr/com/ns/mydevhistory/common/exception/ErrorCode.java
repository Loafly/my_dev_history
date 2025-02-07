package kr.com.ns.mydevhistory.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND("N-USER-001", HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    PROJECT_NOT_FOUND("N-PROJECT-001", HttpStatus.NOT_FOUND, "프로젝트를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR("", HttpStatus.INTERNAL_SERVER_ERROR, "Exception 에러....."),
    ;

    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
