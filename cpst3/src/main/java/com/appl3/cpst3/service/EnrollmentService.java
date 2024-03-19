package com.appl3.cpst3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl3.cpst3.domain.entity.Enrollment;
import com.appl3.cpst3.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    // 학생을 강의에 등록하는 메서드
    public Enrollment enrollStudent(String studentCode, String courseCode, int mileageBet) {
        // Enrollment 객체 생성
        Enrollment enrollment = new Enrollment();
        // 학생 코드 설정
        enrollment.setStudentCode(studentCode);
        // 강의 코드 설정
        enrollment.setCourseCode(courseCode);
        // 베팅한 마일리지 설정
        enrollment.setMileageBet(mileageBet);
        // Enrollment 저장 및 반환
        return enrollmentRepository.save(enrollment);
    }
}
