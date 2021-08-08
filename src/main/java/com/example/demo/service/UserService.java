package com.example.demo.service;

import com.example.demo.entity.user.User;
import com.example.demo.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User makeJoined(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findUserByEmail(String email){
        return userRepository
            .findByEmail(email)
            .orElseThrow(()->new IllegalArgumentException("가입되지 않은 이메일입니다."));
    }

    public void compareInputPasswordToSavedPassword(String inputPassword, String savedPassword){
        if(!passwordEncoder.matches(inputPassword, savedPassword)){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
    }
}
