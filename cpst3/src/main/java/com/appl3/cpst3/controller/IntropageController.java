package com.appl3.cpst3.controller;

import com.appl3.cpst3.domain.dto.LoginRequest;
import com.appl3.cpst3.domain.entity.Student;
import com.appl3.cpst3.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/intropage")
public class IntropageController {

    private final LoginService loginService;

    @Autowired
    public IntropageController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest, HttpSession session, Model model) {
        // 로그인 서비스를 사용하여 로그인을 처리하고, 로그인한 학생 정보를 반환합니다.
        Student loggedInStudent = loginService.login(loginRequest);

        // 로그인에 성공한 경우 세션에 학생 정보를 저장합니다.
        if (loggedInStudent != null) {
            session.setAttribute("loggedInStudent", loggedInStudent);
            return "redirect:/intropage/main"; // 메인 페이지로 이동
        } else {
            // 로그인 실패 시 에러 메시지를 모델에 추가하여 로그인 페이지로 이동합니다.
            model.addAttribute("error", "Invalid student code or password");
            return "login"; // 로그인 페이지로 이동
        }
    }

    // 메인 페이지로 이동
    @RequestMapping("/main")
    public String mainPage() {
        return "main"; // 메인 페이지로 이동하는 HTML 파일의 이름
    }
}
