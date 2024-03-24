package com.appl3.cpst3.domain.entity; // 이 패키지는 com.appl3.cpst3.domain.entity로 정의됨

import jakarta.persistence.Entity; // JPA 엔티티를 나타내는 어노테이션을 가져옴
import jakarta.persistence.GeneratedValue; // 자동 생성되는 키를 나타내는 어노테이션을 가져옴
import jakarta.persistence.GenerationType; // 키의 생성 전략을 지정하는 열거형을 가져옴
import jakarta.persistence.Id; // 엔티티의 기본 키를 나타내는 어노테이션을 가져옴

@Entity // 이 클래스가 JPA 엔티티임을 나타내는 어노테이션
public class Course { // 강의 정보를 나타내는 엔티티 클래스

    @Id // 엔티티의 기본 키를 나타내는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 키의 자동 생성 전략을 IDENTITY로 지정
    private Long id; // 강의의 고유 식별자

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
