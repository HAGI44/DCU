package com.appl3.cpst3.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode; // 강의 코드 (PK)
    private String name; // 강의 이름
    private String grade; // 학점 (varchar(2))
    private String part; // 강의 부분
    private String major; // 주전공
    private Integer credit; // 학점 수
    private String professor; // 담당 교수
    private String day; // 수업 요일
    private String timeStart; // 수업 시작 시간
    private String timeEnd; // 수업 종료 시간
    private String classroom; // 강의실
    private Integer numPersonnel; // 수강 가능한 최대 인원 수
    private Integer numApplicants; // 강의에 신청한 학생 수
}
