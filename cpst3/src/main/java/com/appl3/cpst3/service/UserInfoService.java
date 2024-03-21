package com.appl3.cpst3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl3.cpst3.domain.entity.Student;
import com.appl3.cpst3.repository.StudentRepository;

@Service
public class UserInfoService {

    private final StudentRepository studentRepository;

    @Autowired
    public UserInfoService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 학생 정보를 학번을 통해 조회하는 메서드
    public Student getStudentByStudentCode(String studentCode) {
        // 학번을 기반으로 학생 정보를 데이터베이스에서 조회
        return studentRepository.findByStudentCode(studentCode);
    }
}
