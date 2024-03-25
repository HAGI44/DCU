package com.appl3.cpst3.controller;

import com.appl3.cpst3.domain.entity.Student;
import com.appl3.cpst3.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.appl3.cpst3.domain.dto.LoginRequest;

import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // 로그인 요청을 처리하는 엔드포인트
    @PostMapping("/login")
    public Student login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        // 로그인 서비스를 사용하여 로그인을 처리하고, 로그인한 학생 정보를 반환합니다.
        Student loggedInStudent = loginService.login(loginRequest);
        
        // 로그인에 성공한 경우 세션에 학생 정보를 저장합니다.
        if (loggedInStudent != null) {
            session.setAttribute("loggedInStudent", loggedInStudent);
        }

        return loggedInStudent;
    }
}
