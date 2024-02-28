package com.sugangbk.rest.controller.request;

import com.sugangbk.rest.entity.SubjectType;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class SubjectMakeRequest {
    @NotBlank
    private String name;

    @NotNull
    private Integer credit;

    @NotNull
    private Integer code;

    @NotNull
    private SubjectType type;
}