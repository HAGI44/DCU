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

    public Course getCourseById(long courseId) {
        return courseRepository.findById(courseId);
    }
}