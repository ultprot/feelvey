package com.example.demo.web.dto.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDto<T> {
    private final boolean success;
    private final T response;
    private final ResponseError error;

    private ResponseDto(boolean success, T response, ResponseError error){
        this.success = success;
        this.response = response;
        this.error = error;
    }

    public static <T> ResponseDto<T> OK(T response){
        return new ResponseDto<T>(true, response, null);
    }

    public static ResponseDto<?> ERROR(String message, HttpStatus status){
        return new ResponseDto<>(false, null, new ResponseError(message, status));
    }

    public static ResponseDto<?> ERROR(Throwable throwable, HttpStatus status){
        return new ResponseDto<>(false, null, new ResponseError(throwable, status));
    }
}
