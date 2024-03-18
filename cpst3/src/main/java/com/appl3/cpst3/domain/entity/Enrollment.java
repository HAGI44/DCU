package com.appl3.cpst3.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId; // 학생 ID
    private Long courseId; // 강의 ID
    private int mileageBet; // 학생이 베팅한 마일리지
    
    // 생성자 추가
    public Enrollment(Long studentId, Long courseId, int mileageBet) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.mileageBet = mileageBet;
    }
}