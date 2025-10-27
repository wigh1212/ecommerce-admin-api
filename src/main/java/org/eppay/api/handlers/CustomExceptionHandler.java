package org.eppay.api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.eppay.api.common.error.BaseException;
import org.eppay.api.common.error.ErrorResponse;
import org.eppay.api.common.response.CommonResponse;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseEntity<CommonResponse> handleBaseException(BaseException ex) {
        System.out.println("BaseException");

        String respCode = ex.getRespCode();

        HttpStatus status;

        if (respCode.startsWith("3")) {
            status = HttpStatus.UNAUTHORIZED; // 401 인증 오류
        } else if (respCode.startsWith("4")) {
            status = HttpStatus.INTERNAL_SERVER_ERROR; // 500 서버 오류
        } else {
            status = HttpStatus.BAD_REQUEST; // 기본값 또는 필요에 따라 설정
        }

        return ResponseEntity
                .status(status) // 헤더 HTTP 코드 400
                .body(CommonResponse.fail(ex.getRespMessage(), ex.getRespCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResponse handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage(); // 첫 번째 오류 메시지 추출

        return CommonResponse.fail(message, "2000");
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public ResponseEntity<CommonResponse> handleValidationException(MethodArgumentNotValidException ex) {
//        String message = ex.getBindingResult()
//                .getFieldErrors()
//                .get(0)
//                .getDefaultMessage(); // 첫 번째 오류 메시지 추출
//
//        CommonResponse response = CommonResponse.fail(message, "2000");
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST) // 헤더 HTTP 코드 400
//                .body(response);
//    }
}
