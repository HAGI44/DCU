package com.appl3.cpst3.repository;

import com.appl3.cpst3.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // 학번으로 학생을 조회하는 메서드
    Student findByStudentCode(String studentCode);
}
