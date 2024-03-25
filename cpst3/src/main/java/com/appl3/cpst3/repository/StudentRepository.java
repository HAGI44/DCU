package com.appl3.cpst3.repository; // 이 패키지는 com.appl3.cpst3.repository로 정의됨

import com.appl3.cpst3.domain.entity.Student; // Student 엔티티를 사용하기 위한 import문
import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository를 사용하기 위한 import문

public interface StudentRepository extends JpaRepository<Student, Long> { // Student 엔티티에 대한 JpaRepository를 상속하는 StudentRepository 인터페이스

    // 학번으로 학생을 조회하는 메서드
    Student findByStudentCode(String studentCode); // 학번을 받아 해당 학생을 조회하는 메서드
    
    // 학번과 비밀번호로 학생 정보 조회
    Student findByStudentCodeAndPasswd(String studentCode, String passwd);
}
