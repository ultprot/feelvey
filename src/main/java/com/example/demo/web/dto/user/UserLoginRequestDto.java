package com.example.demo.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Getter
@AllArgsConstructor
public class UserLoginRequestDto {
    @Email
    private String email;

    @Min(8)
    private String password;
}
