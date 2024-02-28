package com.sugangbk.rest.exception;

import com.sugangbk.rest.exception.response.RuntimeExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionAdvisor {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public RuntimeExceptionResponse runtimeExceptionResponse(RuntimeException ex){
        return RuntimeExceptionResponse.builder()
                .exceptionName(ex.getClass().getSimpleName())
                .message(ex.getMessage())
                .build();
    }
}
