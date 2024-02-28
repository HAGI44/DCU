package com.sugangbk.rest.service.dto;

import com.sugangbk.rest.entity.Department;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentRegisterDTO {
    private String loginId;
    private String pw;
    private String name;
    private Department department;
}
