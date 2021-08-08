package com.example.demo.web.dto.user;

import com.example.demo.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collections;

@Getter
@AllArgsConstructor
public class UserJoinRequestDto {
    @NotEmpty
    @Size(min = 1, max = 200)
    private String name;

    @Email
    private String email;

    @NotEmpty
    @Size(min = 8)
    private String password;

    public User toUser(){
        return User.builder()
            .email(email)
            .name(name)
            .password(password)
            .roles(Collections.singletonList("ROLE_USER"))   //최초 가입시 USER로 설정
            .build();
    }
}
