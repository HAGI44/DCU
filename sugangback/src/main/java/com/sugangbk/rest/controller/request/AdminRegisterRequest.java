package com.sugangbk.rest.controller.request;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;

@Data
public class AdminRegisterRequest {
    @NotBlank
    private String loginId;
    @NotBlank
    private String pw;
    @NotBlank
    private String name;
}