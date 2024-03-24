package com.appl3.cpst3.repository; // 이 패키지는 com.appl3.cpst3.repository로 정의됨

import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository를 사용하기 위한 import문
import com.appl3.cpst3.domain.entity.Enrollment; // Enrollment 엔티티를 사용하기 위한 import문

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> { // Enrollment 엔티티에 대한 JpaRepository를 상속하는 EnrollmentRepository 인터페이스

    // 학생 코드로 Enrollment을 조회하는 메소드 추가
    Enrollment findByStudentCode(String studentCode); // 학생 코드를 받아 해당 학생의 수강 신청 정보를 조회하는 메소드 추가

    // 강의 코드로 Enrollment을 조회하는 메소드 추가
    Enrollment findByCourseCode(String courseCode); // 강의 코드를 받아 해당 강의에 대한 수강 신청 정보를 조회하는 메소드 추가
}
