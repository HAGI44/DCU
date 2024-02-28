package com.sugangbk.rest.controller.request;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class CreateDepartmentRequest {
    @NotBlank
    private String name;
    @NotNull
    private Integer code;
}