package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.handler;

import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.controller.SessionController;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = SessionController.class)
public class SessionControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> SessionExceptionHandler(RuntimeException exception) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .message(exception.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

}
