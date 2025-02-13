package kr.com.ns.mydevhistory.common.exception;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Hidden // swagger 와 충돌 제거
@RestControllerAdvice
public class GlobalExceptionHandler {

    // CustomException 처리
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(ApiException exception) {

        ErrorCode errorCode = exception.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode);

        return new ResponseEntity<>(errorResponse, errorCode.getHttpStatus());
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
//
//        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
//        ErrorResponse errorResponse = new ErrorResponse(errorCode, ex.getMessage());
//
//        return new ResponseEntity<>(errorResponse, errorCode.getHttpStatus());
//    }
}
