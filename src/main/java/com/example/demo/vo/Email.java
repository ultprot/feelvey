package com.example.demo.vo;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Email {
    private static final String AT = "@";

    @NotNull
    @NotBlank
    private String id;

    @NotNull
    @NotBlank
    private String domain;

    private String getFullAddress;
}
