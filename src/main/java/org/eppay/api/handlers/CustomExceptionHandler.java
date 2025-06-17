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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> details = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            details.add(error.getField() + " : " + error.getDefaultMessage());
        }

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public CommonResponse handleBaseException(BaseException ex) {
        System.out.println("BaseException");
        if(ex.getRespCode().startsWith("4")) {
            // 시스템 장애 상황이므로 로그를 남긴다.
            throw ex;
        }
        return CommonResponse.fail(ex.getRespMessage(), ex.getRespCode());
    }
}
