package com.sugangbk.rest.service;

import com.sugangbk.rest.entity.member.Admin;
import com.sugangbk.rest.entity.member.MemberInfo;
import com.sugangbk.rest.exception.exception.DuplicatedEntityException;
import com.sugangbk.rest.repository.AdminRepository;
import com.sugangbk.rest.service.dto.AdminRegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public Optional<Admin> login(String loginId, String pw) {
        return adminRepository.findAllByLoginId(loginId).stream()
                .filter(e -> e.getMemberInfo().getActivated())
                .filter(e -> passwordEncoder.matches(pw, e.getMemberInfo().getPw()))
                .findAny();
    }
    public Admin register(AdminRegisterDTO adminRegisterDTO) {
        if(isDuplicatedLoginId(adminRegisterDTO.getLoginId()))
            throw new DuplicatedEntityException();

        Admin admin = Admin.builder()
                .memberInfo(
                        MemberInfo.builder()
                                .loginId(adminRegisterDTO.getLoginId())
                                .pw(adminRegisterDTO.getPw())
                                .name(adminRegisterDTO.getName())
                                .activated(true)
                                .build())
                .build();

        return adminRepository.save(admin);
    }

    private boolean isDuplicatedLoginId(String loginId) {
        return adminRepository.findAllByLoginId(loginId).stream()
                .anyMatch(e -> e.getMemberInfo().getActivated());
    }

    public void inactive(Admin admin){
        admin.getMemberInfo().setActivated(false);
    }
}
