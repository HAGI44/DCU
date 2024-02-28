package com.sugangbk.rest.controller;

import com.sugangbk.rest.aop.annotation.PermitStudent;
import com.sugangbk.rest.controller.request.StudentRegisterRequest;
import com.sugangbk.rest.controller.response.BasketResponse;
import com.sugangbk.rest.controller.response.LoginResponse;
import com.sugangbk.rest.entity.Department;
import com.sugangbk.rest.entity.member.Student;
import com.sugangbk.rest.exception.exception.NoExistEntityException;
import com.sugangbk.rest.repository.BasketRepository;
import com.sugangbk.rest.repository.DepartmentRepository;
import com.sugangbk.rest.repository.StudentRepository;
import com.sugangbk.rest.service.StudentService;
import com.sugangbk.rest.service.dto.StudentRegisterDTO;
import com.sugangbk.rest.session.SessionConst;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentRestController {

    private final StudentService studentService;

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final BasketRepository basketRepository;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    @Valid
    ResponseEntity<LoginResponse> login(
            @RequestParam @NotBlank String loginId,
            @RequestParam @NotBlank String pw,
            HttpServletRequest request,
            HttpServletResponse response) {
        Student student = studentService.login(loginId, pw).orElseThrow(NoExistEntityException::new);

        HttpSession session = request.getSession(true);
        session.setAttribute(SessionConst.LOGIN_STUDENT, student.getId());
        session.setMaxInactiveInterval(1800);
        log.info("Session Create [SessionId : {}]", session.getId());

        response.addCookie(new Cookie("JSESSIONID", session.getId()));

        return ResponseEntity.ok(LoginResponse.builder()
                .id(student.getId())
                .type(SessionConst.LOGIN_STUDENT)
                .name(student.getMemberInfo().getName())
                .departmentName(student.getDepartment().getName())
                .build());
    }

    @PostMapping("/logout")
    void logout(HttpServletRequest request) {
        logoutStudent(request);
    }

    private void logoutStudent(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null)
            return;
        session.invalidate();
    }

    @PostMapping("/register")
    void register(@RequestBody @Valid StudentRegisterRequest studentRegisterRequest) {
        Department department = departmentRepository.findById(studentRegisterRequest.getDepartmentId())
                .orElseThrow(NoExistEntityException::new);

        String encodedPw = passwordEncoder.encode(studentRegisterRequest.getPw());
        studentRegisterRequest.setPw(encodedPw);

        StudentRegisterDTO studentRegisterDTO = StudentRegisterDTO.builder()
                .name(studentRegisterRequest.getName())
                .pw(studentRegisterRequest.getPw())
                .loginId(studentRegisterRequest.getLoginId())
                .department(department)
                .build();

        studentService.register(studentRegisterDTO);
    }

    @PermitStudent
    @PostMapping("/inactive")
    @Valid
    void inactiveSubject(@Parameter(hidden = true) @SessionAttribute(name = SessionConst.LOGIN_STUDENT, required = false) Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(NoExistEntityException::new);
        studentService.inactive(student);
    }

    @PermitStudent
    @PostMapping("/basket")
    Page<BasketResponse> baskets(
            @Parameter(hidden = true) @SessionAttribute(name = SessionConst.LOGIN_STUDENT, required = false) Long studentId,
            Pageable pageable) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(NoExistEntityException::new);

        return basketRepository.findAllByStudent(student, pageable)
                .map(BasketResponse::new);
    }
}