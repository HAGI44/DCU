package com.appl3.cpst3.controller; // 이 패키지는 com.appl3.cpst3.controller로 정의됨

import org.springframework.beans.factory.annotation.Autowired; // 스프링의 의존성 주입을 위한 어노테이션을 가져옴
import org.springframework.web.bind.annotation.GetMapping; // HTTP GET 요청을 처리하는 어노테이션을 가져옴
import org.springframework.web.bind.annotation.RestController; // RESTful 웹 서비스의 컨트롤러를 나타내는 어노테이션을 가져옴
import com.appl3.cpst3.domain.entity.Enrollment; // Enrollment 엔티티 클래스를 가져옴
import com.appl3.cpst3.service.ResultService; // ResultService 클래스를 가져옴
import java.util.List; // 리스트를 사용하기 위한 자바 유틸리티 패키지를 가져옴

@RestController // 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 선언
public class ResultController {
    private final ResultService resultService; // ResultService 타입의 resultService 필드 선언

    @Autowired // 의존성 주입을 위한 생성자를 선언
    public ResultController(ResultService resultService) {
        this.resultService = resultService; // 주입된 ResultService를 사용하여 resultService 필드 초기화
    }

    // 수강신청이 완료된 과목을 조회하는 컨트롤러 메서드
    @GetMapping("/completed-enrollments") // HTTP GET 요청을 /completed-enrollments 엔드포인트에 매핑
    public List<Enrollment> getCompletedEnrollments() {
        // ResultService를 통해 수강신청이 완료된 과목을 조회하고 반환
        return resultService.getCompletedEnrollments(); // 수강신청이 완료된 과목 리스트를 반환
    }
}
