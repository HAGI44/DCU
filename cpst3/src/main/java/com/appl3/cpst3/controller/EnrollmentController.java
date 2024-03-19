package com.appl3.cpst3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appl3.cpst3.domain.entity.Enrollment;
import com.appl3.cpst3.service.EnrollmentService;

@RestController
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // 학생을 강의에 등록하는 엔드포인트
    @PostMapping("/enrollments")
    public Enrollment enrollStudent(@RequestBody Enrollment enrollmentRequest) {
        // enrollmentRequest를 통해 HTTP 요청의 바디에 있는 데이터를 읽어옵니다.
        // 이 데이터를 바탕으로 Enrollment 객체를 생성하여 서비스에 전달합니다.
        return enrollmentService.enrollStudent(enrollmentRequest.getStudentCode(), 
                                               enrollmentRequest.getCourseCode(), 
                                               enrollmentRequest.getMileageBet());
    }
}
