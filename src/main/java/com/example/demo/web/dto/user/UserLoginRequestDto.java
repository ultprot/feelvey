package com.example.demo.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class UserLoginRequestDto {
    @Email
    private String email;

    @Size(min = 8)
    private String password;
}
