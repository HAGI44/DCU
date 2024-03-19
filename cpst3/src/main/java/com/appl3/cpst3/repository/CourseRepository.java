package com.appl3.cpst3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appl3.cpst3.domain.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // 강의 코드로 조회하는 메서드 추가
    Course findByCourseCode(String courseCode);
}
