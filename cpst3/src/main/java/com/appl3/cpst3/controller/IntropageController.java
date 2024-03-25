package com.appl3.cpst3.controller; // 이 패키지는 com.appl3.cpst3.controller로 정의되어 있음

import lombok.RequiredArgsConstructor; // Lombok 어노테이션을 사용하여 생성자 주입을 위한 어노테이션을 가져옴
import org.springframework.stereotype.Controller; // 스프링 컨트롤러를 나타내는 어노테이션을 가져옴
import org.springframework.ui.Model; // Spring의 모델을 나타내는 클래스를 가져옴
import org.springframework.validation.BindingResult; // 바인딩 결과를 나타내는 클래스를 가져옴
import org.springframework.validation.FieldError; // 필드 에러를 나타내는 클래스를 가져옴
import org.springframework.web.bind.annotation.*; // 웹 요청을 처리하는 어노테이션을 가져옴

import com.appl3.cpst3.domain.dto.LoginRequest; // 로그인 요청 DTO 클래스를 가져옴
import com.appl3.cpst3.domain.entity.User; // 사용자 엔티티 클래스를 가져옴
import com.appl3.cpst3.service.UserService; // 사용자 서비스 클래스를 가져옴
import com.appl3.cpst3.domain.UserRole; // 사용자 역할 열거형을 가져옴

import jakarta.servlet.http.HttpServletRequest; // javax.servlet.http 패키지에서 HttpServletRequest 클래스를 가져옴
import jakarta.servlet.http.HttpSession; // javax.servlet.http 패키지에서 HttpSession 클래스를 가져옴
import java.util.Enumeration; // java.util 패키지에서 Enumeration 클래스를 가져옴
import java.util.HashMap; // java.util 패키지에서 HashMap 클래스를 가져옴
import java.util.Map; // java.util 패키지에서 Map 인터페이스를 가져옴

@Controller // 이 클래스가 스프링 컨트롤러임을 나타냄
@RequiredArgsConstructor // 생성자 주입을 위한 Lombok 어노테이션을 사용하여 필드를 final로 선언하고 생성자를 생성함
@RequestMapping("/intropage") // 이 컨트롤러에 대한 기본 URL 매핑을 정의함
public class IntropageController {

    private final UserService userService; // UserService 타입의 필드를 final로 선언하고 생성자를 통해 주입받음

    /**
     * 시작 페이지 또는 로그인 후 홈 페이지
     */
    @GetMapping(value = {"", "/"}) // HTTP GET 요청을 처리하며, /intropage 및 /intropage/ 경로로 접근 가능함
    public String home(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        // 모델에 페이지 정보 추가
        model.addAttribute("loginType", "intropage"); // 모델에 loginType 속성을 추가하여 현재 페이지의 로그인 타입을 설정함
        model.addAttribute("pageName", "시작 페이지"); // 모델에 pageName 속성을 추가하여 현재 페이지의 이름을 설정함

        // 세션에서 로그인한 사용자 정보 가져오기
        User loginUser = userService.getLoginUserById(userId);

        // 로그인한 사용자가 있으면 이름을 페이지에 표시
        if (loginUser != null) {
            model.addAttribute("nickname", loginUser.getName()); // 모델에 nickname 속성을 추가하여 로그인한 사용자의 닉네임을 설정함
        }

        return "home"; // home.html 템플릿을 렌더링함
    }

    // join 페이지 관련 코드는 삭제합니다.

    /**
     * 로그인 페이지
     */
    @GetMapping("/login") // HTTP GET 요청을 처리하며, /intropage/login 경로로 접근 가능함
    public String loginPage(Model model) {
        // 모델에 페이지 정보 추가
        model.addAttribute("loginType", "intropage"); // 모델에 loginType 속성을 추가하여 현재 페이지의 로그인 타입을 설정함
        model.addAttribute("pageName", "시작 페이지"); // 모델에 pageName 속성을 추가하여 현재 페이지의 이름을 설정함

        // 로그인 폼 데이터 전달을 위한 객체 생성
        model.addAttribute("loginRequest", new LoginRequest()); // 모델에 loginRequest 속성을 추가하여 빈 LoginRequest 객체를 설정함
        return "login"; // login.html 템플릿을 렌더링함
    }

    /**
     * 로그인 처리
     */
    @PostMapping("/login") // HTTP POST 요청을 처리하며, /intropage/login 경로로 접근 가능함
    public String login(@ModelAttribute LoginRequest loginRequest, BindingResult bindingResult,
                        HttpServletRequest httpServletRequest, Model model) {
        // 모델에 페이지 정보 추가
        model.addAttribute("loginType", "intropage"); // 모델에 loginType 속성을 추가하여 현재 페이지의 로그인 타입을 설정함
        model.addAttribute("pageName", "시작 페이지"); // 모델에 pageName 속성을 추가하여 현재 페이지의 이름을 설정함

        // 로그인 시도
        User user = userService.login(loginRequest);

        // 로그인 실패 시 에러 처리
        if (user == null) {
            bindingResult.reject("loginFail", "로그인 아이디 또는 비밀번호가 틀렸습니다."); // 바인딩 결과에 로그인 실패 에러 추가
        }

        // 에러 발생 시 로그인 페이지 다시 표시
        if (bindingResult.hasErrors()) {
            return "login"; // login.html 템플릿을 렌더링함
        }

        // 로그인 성공 시 세션 생성
        httpServletRequest.getSession().invalidate(); // 기존 세션 무효화
        HttpSession session = httpServletRequest.getSession(true); // 새로운 세션 생성
        session.setAttribute("userId", user.getId()); // 세션에 userId 속성을 추가하여 현재 로그인한 사용자의 ID를 설정함
        session.setMaxInactiveInterval(1800); // 세션 유효 시간을 30분으로 설정함

        return "redirect:/intropage"; // 시작 페이지로 리다이렉트함
    }

    /**
     * 로그아웃
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        // 모델에 페이지 정보 추가
        model.addAttribute("loginType", "intropage");
        model.addAttribute("pageName", "시작 페이지");

        // 세션 파기
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/intropage";
    }

    /**
     * 사용자 정보 페이지
     */
    @GetMapping("/info")
    public String userInfo(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
        // 모델에 페이지 정보 추가
        model.addAttribute("loginType", "intropage");
        model.addAttribute("pageName", "시작 페이지");

        // 세션에서 로그인한 사용자 정보 가져오기
        User loginUser = userService.getLoginUserById(userId);

        // 로그인한 사용자가 없으면 로그인 페이지로 리다이렉트
        if (loginUser == null) {
            return "redirect:/intropage/login";
        }

        // 사용자 정보 모델에 추가
        model.addAttribute("user", loginUser);
        return "info";
    }

    /**
     * 관리자 페이지
     */
    @GetMapping("/admin")
    public String adminPage(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
        // 모델에 페이지 정보 추가
        model.addAttribute("loginType", "intropage");
        model.addAttribute("pageName", "시작 페이지");

        // 세션에서 로그인한 사용자 정보 가져오기
        User loginUser = userService.getLoginUserById(userId);

        // 로그인한 사용자가 없으면 로그인 페이지로 리다이렉트
        if (loginUser == null) {
            return "redirect:/intropage/login";
        }

        // 관리자가 아니면 홈 페이지로 리다이렉트
        if (!loginUser.getRole().equals(UserRole.ADMIN)) {
            return "redirect:/intropage";
        }

        return "admin";
    }

    // 세션 리스트 확인용 코드는 삭제합니다.
}