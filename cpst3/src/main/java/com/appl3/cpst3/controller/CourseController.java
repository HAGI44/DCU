package com.appl3.cpst3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.appl3.cpst3.domain.entity.Course;
import com.appl3.cpst3.service.CourseService;

@RestController
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // 주어진 id에 해당하는 강의 정보를 조회하는 메서드
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseService.getCourseById(id);
    }
}
