package com.appl3.cpst3.service; // 이 패키지는 com.appl3.cpst3.service로 정의됨

import org.springframework.beans.factory.annotation.Autowired; // Autowired 어노테이션을 사용하기 위한 import문
import org.springframework.stereotype.Service; // Service 어노테이션을 사용하기 위한 import문

import com.appl3.cpst3.domain.entity.Enrollment; // Enrollment 엔티티를 사용하기 위한 import문
import com.appl3.cpst3.repository.EnrollmentRepository; // EnrollmentRepository를 사용하기 위한 import문

@Service // Spring의 Service로 정의되는 클래스임을 나타내는 어노테이션
public class EnrollmentService { // EnrollmentService 클래스 선언

    private final EnrollmentRepository enrollmentRepository; // EnrollmentRepository 객체 선언

    @Autowired // 의존성 주입을 위한 Autowired 어노테이션
    public EnrollmentService(EnrollmentRepository enrollmentRepository) { // EnrollmentService 생성자
        this.enrollmentRepository = enrollmentRepository; // 생성자를 통해 주입된 EnrollmentRepository 객체를 초기화
    }

    // 학생을 강의에 등록하는 메서드
    public Enrollment enrollStudent(String studentCode, String courseCode, int mileageBet) { // 학생 코드, 강의 코드, 베팅 마일리지를 받아 학생을 강의에 등록하는 메서드
        // Enrollment 객체 생성
        Enrollment enrollment = new Enrollment(); // Enrollment 객체 생성
        // 학생 코드 설정
        enrollment.setStudentCode(studentCode); // 학생 코드 설정
        // 강의 코드 설정
        enrollment.setCourseCode(courseCode); // 강의 코드 설정
        // 베팅한 마일리지 설정
        enrollment.setMileageBet(mileageBet); // 베팅한 마일리지 설정
        // Enrollment 저장 및 반환
        return enrollmentRepository.save(enrollment); // 생성된 Enrollment 객체를 저장하고 반환
    }
}
