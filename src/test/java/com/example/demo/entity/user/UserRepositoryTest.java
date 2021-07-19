package com.example.demo.entity.user;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @AfterEach
    public void cleanUp(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("사용자 저장, 불러오기")
    public void saveAndLoadUser(){
        //given
        String name = "테스트 이름";
        String email = "testemail@gmail.com";
        String password = "testpassword";

        userRepository.save(User.builder()
            .name(name)
            .email(email)
            .password(password)
            .build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
    }
}