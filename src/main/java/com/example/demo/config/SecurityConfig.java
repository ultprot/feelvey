package com.example.demo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //기본 로그인 사용 하지 않음
        http
                .httpBasic()
                .disable();

        //h2-console 사용
        http
                .authorizeRequests()
                .antMatchers("/h2-console/**")
                .permitAll();

        //csrf 사용 하지 않음
        http

                .csrf()
                .disable();

        //frameoption 사용 하지 않음
        http
                .headers()
                .frameOptions()
                .disable();
    }
}
