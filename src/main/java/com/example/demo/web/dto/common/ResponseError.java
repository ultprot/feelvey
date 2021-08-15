package com.example.demo.web.dto.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseError {
    private final String message;
    private final int status;

    ResponseError(Throwable throwable, HttpStatus status){
        this(throwable.getMessage(), status);
    }

    ResponseError(String message, HttpStatus status){
        this.message = message;
        this.status = status.value();
    }
}
