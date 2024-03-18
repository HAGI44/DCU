package com.appl3.cpst3.service;

import lombok.RequiredArgsConstructor;
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

    public Enrollment enrollStudent(Long studentId, Long courseId, int mileageBet) {
        // 생성자를 통해 Enrollment 객체 생성
        Enrollment enrollment = new Enrollment(studentId, courseId, mileageBet);
        return enrollmentRepository.save(enrollment);
    }
}