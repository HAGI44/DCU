package com.appl3.cpst3.service; // com.appl3.cpst3.service 패키지 정의

import org.springframework.beans.factory.annotation.Autowired; // Autowired 어노테이션을 사용하기 위한 import문
import org.springframework.stereotype.Service; // Service 어노테이션을 사용하기 위한 import문
import com.appl3.cpst3.domain.entity.Student; // Student 엔티티를 사용하기 위한 import문
import com.appl3.cpst3.repository.StudentRepository; // StudentRepository를 사용하기 위한 import문

@Service // Spring의 Service로 정의되는 클래스임을 나타내는 어노테이션
public class UserInfoService { // UserInfoService 클래스 선언

    private final StudentRepository studentRepository; // StudentRepository 객체 선언

    @Autowired // 의존성 주입을 위한 Autowired 어노테이션
    public UserInfoService(StudentRepository studentRepository) { // UserInfoService 생성자
        this.studentRepository = studentRepository; // 생성자를 통해 주입된 StudentRepository 객체를 초기화
    }

    // 학생 정보를 학번을 통해 조회하는 메서드
    public Student getStudentByStudentCode(String studentCode) { // 학번을 입력받아 해당 학생 정보를 반환하는 메서드
        // 학번을 기반으로 학생 정보를 데이터베이스에서 조회하여 반환
        return studentRepository.findByStudentCode(studentCode);
    }
}
