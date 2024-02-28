package com.sugangbk.rest.entity;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer code;

    @Builder.Default
    @Setter
    private Boolean activated = true;
}
