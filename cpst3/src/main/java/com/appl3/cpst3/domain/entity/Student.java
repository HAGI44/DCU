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
    private String studentCode; // 학생 코드 (PK, FK)
    private String idNumber; // 학생 식별 번호
    private String name; // 학생 이름
    private String major; // 주전공
    private String doubleMajor; // 복수전공
    private int grade; // 학년
    private int term; // 학기
    private int numCourses; // 수강한 과목 수
    private boolean preGraduation; // 졸업예정자
    private boolean excellent; // 성적우수자 여부
    private boolean doubleMajorcheck; // 복수전공자 여부

 // 성적우수자 여부 반환
    public boolean isExcellent() {
        return this.excellent;
    }

    // 복수전공자 여부 반환
    public boolean isDoubleMajorcheck() {
        return this.doubleMajorcheck;
    }

    // 졸업예정자 여부 반환
    public boolean isPreGraduation() {
        return this.preGraduation;
    }
}
