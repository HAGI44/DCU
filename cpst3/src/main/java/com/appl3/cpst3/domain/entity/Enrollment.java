package com.appl3.cpst3.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentCode; // 학생 코드 (FK)
    private String courseCode; // 강의 코드 (FK)
    private int mileageBet; // 학생이 베팅한 마일리지
    
    // 생성자 추가
    public Enrollment(String studentCode, String courseCode, int mileageBet) {
        this.studentCode = studentCode;
        this.courseCode = courseCode;
        this.mileageBet = mileageBet;
    }
    
    // 각 필드의 게터와 세터는 롬복을 사용하여 자동 생성됨
    
    // 롬복을 사용하여 생성된 게터와 세터는 생략
}