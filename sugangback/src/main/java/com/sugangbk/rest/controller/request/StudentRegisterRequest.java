package com.sugangbk.rest.controller.request;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class StudentRegisterRequest {
    @NotBlank
    private String loginId;
    @NotBlank
    private String pw;
    @NotBlank
    private String name;
    @NotNull
    private Long departmentId;
}