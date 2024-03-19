package com.appl3.cpst3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appl3.cpst3.repository.CourseRepository;
import com.appl3.cpst3.domain.entity.Course;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // 주어진 courseId를 사용하여 해당하는 강의를 조회하는 메서드
    public Course getCourseById(long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }
    // 오류 발생 시 null에 대한 예외 처리 필요
}
