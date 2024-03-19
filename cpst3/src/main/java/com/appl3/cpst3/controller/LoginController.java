package com.appl3.cpst3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.appl3.cpst3.domain.dto.LoginRequest;
import com.appl3.cpst3.domain.entity.User;
import com.appl3.cpst3.service.UserService;
import com.appl3.cpst3.domain.UserRole;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/intropage")
public class LoginController {

	private final UserService userService;

    @GetMapping(value = {"", "/"})
    public String home(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "intropage");
        model.addAttribute("pageName", "시작 페이지");

        User loginUser = userService.getLoginUserById(userId);

        if(loginUser != null) {
            model.addAttribute("nickname", loginUser.getName()); // 이름으로 변경
        }

        return "home";
    }

    // join 페이지 관련 코드는 삭제합니다.

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginType", "intropage");
        model.addAttribute("pageName", "시작 페이지");

        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, BindingResult bindingResult,
                        HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("loginType", "intropage");
        model.addAttribute("pageName", "시작 페이지");

        User user = userService.login(loginRequest);

        // 로그인 아이디나 비밀번호가 틀린 경우 global error return
        if(user == null) {
            bindingResult.reject("loginFail", "로그인 아이디 또는 비밀번호가 틀렸습니다.");
        }

        if(bindingResult.hasErrors()) {
            return "login";
        }

        // 로그인 성공 => 세션 생성

        // 세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);  // Session이 없으면 생성
        // 세션에 userId를 넣어줌
        session.setAttribute("userId", user.getId());
        session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

        return "redirect:/intropage";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        model.addAttribute("loginType", "intropage");
        model.addAttribute("pageName", "시작 페이지");

        HttpSession session = request.getSession(false);  // Session이 없으면 null return
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/intropage";
    }

    @GetMapping("/info")
    public String userInfo(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
        model.addAttribute("loginType", "intropage");
        model.addAttribute("pageName", "시작 페이지");

        User loginUser = userService.getLoginUserById(userId);

        if(loginUser == null) {
            return "redirect:/intropage/login";
        }

        model.addAttribute("user", loginUser);
        return "info";
    }

    @GetMapping("/admin")
    public String adminPage(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
        model.addAttribute("loginType", "intropage");
        model.addAttribute("pageName", "시작 페이지");

        User loginUser = userService.getLoginUserById(userId);

        if(loginUser == null) {
            return "redirect:/intropage/login";
        }

        if(!loginUser.getRole().equals(UserRole.ADMIN)) {
            return "redirect:/intropage";
        }

        return "admin";
    }

    // 세션 리스트 확인용 코드는 삭제합니다.
}
