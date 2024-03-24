package com.appl3.cpst3.controller; // 이 패키지는 com.appl3.cpst3.controller로 정의됨

import org.springframework.beans.factory.annotation.Autowired; // 스프링의 의존성 주입을 위한 어노테이션을 가져옴
import org.springframework.web.bind.annotation.GetMapping; // HTTP GET 요청을 처리하는 어노테이션을 가져옴
import org.springframework.web.bind.annotation.RequestMapping; // 요청 매핑을 정의하는 어노테이션을 가져옴
import org.springframework.web.bind.annotation.RestController; // RESTful 웹 서비스의 컨트롤러를 나타내는 어노테이션을 가져옴
import jakarta.servlet.http.HttpSession; // 서블릿 세션을 다루기 위한 클래스를 가져옴
import com.appl3.cpst3.domain.entity.Student; // Student 엔티티 클래스를 가져옴
import com.appl3.cpst3.service.UserInfoService; // UserInfoService 클래스를 가져옴

@RestController // 이 클래스가 RESTful 웹 서비스의 컨트롤러임을 선언
@RequestMapping("/userinfo") // 요청을 /userinfo 하위로 매핑
public class UserInfoController {

    private final UserInfoService userInfoService; // UserInfoService 타입의 userInfoService 필드 선언

    @Autowired // 의존성 주입을 위한 생성자를 선언
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService; // 주입된 UserInfoService를 사용하여 userInfoService 필드 초기화
    }

    // 로그인 후 메인 페이지에서 학생 정보를 표시하는 메서드
    @GetMapping("/main") // HTTP GET 요청을 /userinfo/main 엔드포인트에 매핑
    public Student getStudentInfo(HttpSession session) {
        // 세션에서 로그인한 학생의 학번을 가져옴
        String studentCode = (String) session.getAttribute("studentCode");
        
        // 학번을 통해 학생 정보를 조회하여 반환
        return userInfoService.getStudentByStudentCode(studentCode); // 학생 정보를 반환
    }
}
