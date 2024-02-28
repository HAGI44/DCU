package com.sugangbk.rest.entity.member;

import lombok.*;

import jakarta.persistence.Embeddable;

@Embeddable
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfo{
    private String name;

    private String loginId;

    private String pw;

    @Builder.Default
    @Setter
    private Boolean activated = true;
}
