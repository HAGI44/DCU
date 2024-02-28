package com.sugangbk.rest.controller;

import com.sugangbk.rest.aop.annotation.PermitAdmin;
import com.sugangbk.rest.controller.request.AdminRegisterRequest;
import com.sugangbk.rest.controller.response.LoginResponse;
import com.sugangbk.rest.entity.member.Admin;
import com.sugangbk.rest.exception.exception.NoExistEntityException;
import com.sugangbk.rest.repository.AdminRepository;
import com.sugangbk.rest.service.AdminService;
import com.sugangbk.rest.service.dto.AdminRegisterDTO;
import com.sugangbk.rest.session.SessionConst;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/admin")
@Transactional
@Slf4j
public class AdminRestController {

    private final AdminService adminService;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    // 생성자 추가
    public AdminRestController(AdminService adminService, AdminRepository adminRepository,
                               PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.adminService = adminService;
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/login")
    @Valid
    ResponseEntity<LoginResponse> login(
            @RequestParam @NotBlank String loginId,
            @RequestParam @NotBlank String pw,
            HttpServletRequest request) {
        Admin admin = adminService.login(loginId, pw).orElseThrow(NoExistEntityException::new);

        HttpSession session = request.getSession(true);
        session.setAttribute(SessionConst.LOGIN_ADMIN, admin.getId());
        session.setMaxInactiveInterval(1800);
        log.info("Admin Session Create [SessionId : {}]", session.getId());

        return ResponseEntity.ok(LoginResponse.builder()
                .id(admin.getId())
                .type(SessionConst.LOGIN_ADMIN)
                .name(admin.getMemberInfo().getName())
                .build());
    }

    @PostMapping("/logout")
    void logout(HttpServletRequest request) {
        logoutAdmin(request);
    }

    private void logoutAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null)
            return;
        session.invalidate();
    }

    @PostMapping("/register")
    void register(@RequestBody @Valid AdminRegisterRequest adminRegisterRequest) {
        String encodedPw = passwordEncoder.encode(adminRegisterRequest.getPw());
        adminRegisterRequest.setPw(encodedPw);

        AdminRegisterDTO adminRegisterDTO = modelMapper.map(adminRegisterRequest, AdminRegisterDTO.class);
        adminService.register(adminRegisterDTO);
    }

    @PermitAdmin
    @PostMapping("/inactive")
    @Valid
    void inactiveSubject(@Parameter(hidden = true) @SessionAttribute(name = SessionConst.LOGIN_PROFESSOR, required = false) Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(NoExistEntityException::new);
        adminService.inactive(admin);
    }
}
