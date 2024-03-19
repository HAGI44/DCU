package com.appl3.cpst3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appl3.cpst3.domain.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // 추가적인 메서드가 필요하다면 여기에 작성
    
    // 학생 코드로 Enrollment을 조회하는 메서드 추가
    Enrollment findByStudentCode(String studentCode);
    
    // 강의 코드로 Enrollment을 조회하는 메서드 추가
    Enrollment findByCourseCode(String courseCode);
}
