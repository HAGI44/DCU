package com.sugangbk.rest.service.dto;

import com.sugangbk.rest.entity.SubjectType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectMakeDTO {
    private String name;

    private Integer credit;

    private Integer code;

    private SubjectType type;
}
