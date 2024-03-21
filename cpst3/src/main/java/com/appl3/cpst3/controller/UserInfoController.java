package com.appl3.cpst3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;
import com.appl3.cpst3.domain.entity.Student;
import com.appl3.cpst3.service.UserInfoService;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    // 로그인 후 메인 페이지에서 학생 정보를 표시하는 메서드
    @GetMapping("/main")
    public Student getStudentInfo(HttpSession session) {
        // 세션에서 로그인한 학생의 학번을 가져옴
        String studentCode = (String) session.getAttribute("studentCode");
        
        // 학번을 통해 학생 정보를 조회하여 반환
        return userInfoService.getStudentByStudentCode(studentCode);
    }
}
