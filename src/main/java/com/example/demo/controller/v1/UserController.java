package com.example.demo.controller.v1;


import com.example.demo.config.security.JwtTokenProvider;
import com.example.demo.entity.user.User;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.user.UserJoinRequestDto;
import com.example.demo.web.dto.user.UserLoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    //회원 가입
    @PostMapping("/join")
    public Long join(
        @RequestBody
        @Valid
        UserJoinRequestDto userDto
    ) {
        return userService
                .makeJoined(userDto.toUser())
                .getId();
    }

    //로그인
    @PostMapping("/login")
    public String login(
        @RequestBody
        @Valid
        UserLoginRequestDto userDto
    ) {
        User user = userService.findUserByEmail(userDto.getEmail());
        userService.compareInputPasswordToSavedPassword(userDto.getPassword(), user.getPassword());

        return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
    }

    //로그인
    @GetMapping("/validity")
    public String validate(
    ) {
        return "ok";
    }
}
