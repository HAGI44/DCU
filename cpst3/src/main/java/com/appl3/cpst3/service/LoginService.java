package com.appl3.cpst3.service;

import com.appl3.cpst3.domain.dto.LoginRequest;
import com.appl3.cpst3.domain.entity.Student;
import com.appl3.cpst3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final StudentRepository studentRepository;

    @Autowired
    public LoginService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 로그인 요청을 처리하는 메서드
    public Student login(LoginRequest loginRequest) {
        // 입력된 아이디와 비밀번호로 학생 정보를 조회합니다.
        Student student = studentRepository.findByStudentCodeAndPasswd(loginRequest.getStudentCode(), loginRequest.getPasswd());
        return student;
    }
}
