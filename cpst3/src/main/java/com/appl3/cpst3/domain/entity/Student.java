package com.appl3.cpst3.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean excellent; // 성적우수자 여부
    private boolean doubleMajor; // 복수전공자 여부
    private boolean graduationCandidate; // 졸업예정자 여부

    // 생성자, 게터, 세터 등
}
