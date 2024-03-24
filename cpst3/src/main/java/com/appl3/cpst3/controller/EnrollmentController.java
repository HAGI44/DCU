package com.appl3.cpst3.controller; // 이 패키지는 com.appl3.cpst3.controller로 정의되어 있음

import org.springframework.beans.factory.annotation.Autowired; // 스프링의 의존성 주입을 위한 어노테이션을 가져옴
import org.springframework.web.bind.annotation.PostMapping; // HTTP POST 요청을 처리하는 어노테이션을 가져옴
import org.springframework.web.bind.annotation.RequestBody; // HTTP 요청의 바디를 읽어오는 어노테이션을 가져옴
import org.springframework.web.bind.annotation.RestController; // RESTful 웹 서비스의 컨트롤러를 나타내는 어노테이션을 가져옴

import com.appl3.cpst3.domain.entity.Enrollment; // Enrollment 엔티티 클래스를 가져옴
import com.appl3.cpst3.service.EnrollmentService; // EnrollmentService 클래스를 가져옴

@RestController // 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 선언
public class EnrollmentController {
    private final EnrollmentService enrollmentService; // EnrollmentService 타입의 enrollmentService 필드 선언

    @Autowired // 의존성 주입을 위한 생성자를 선언
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService; // 주입된 EnrollmentService를 사용하여 enrollmentService 필드 초기화
    }

    // 학생을 강의에 등록하는 엔드포인트
    @PostMapping("/enrollments") // HTTP POST 요청을 /enrollments 엔드포인트에 매핑
    public Enrollment enrollStudent(@RequestBody Enrollment enrollmentRequest) {
        // @RequestBody 어노테이션으로 HTTP 요청의 바디에서 데이터를 읽어와서 enrollmentRequest 객체에 매핑
        // 이 데이터를 사용하여 학생을 강의에 등록하는 enrollStudent 메소드를 호출하고 그 결과를 반환
        return enrollmentService.enrollStudent(enrollmentRequest.getStudentCode(), 
                                               enrollmentRequest.getCourseCode(), 
                                               enrollmentRequest.getMileageBet());
    }
}
