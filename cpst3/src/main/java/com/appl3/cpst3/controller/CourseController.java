package com.appl3.cpst3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appl3.cpst3.domain.entity.Course;
import com.appl3.cpst3.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // 주어진 전공에 해당하는 강의들을 조회하는 메서드
    @GetMapping("/major/{major}")
    public List<Course> getCoursesByMajor(@PathVariable String major) {
        return courseService.getCoursesByMajor(major);
    }

    // 주어진 강의 이름에 해당하는 강의 정보를 조회하는 메서드
    @GetMapping("/name/{name}")
    public Course getCourseByName(@PathVariable String name) {
        return courseService.getCourseByName(name);
    }

    // 주어진 요일과 수업 시간에 해당하는 강의들을 조회하는 메서드
    @GetMapping("/day/{day}/time/{time}")
    public List<Course> getCoursesByDayAndTime(@PathVariable String day, @PathVariable String time) {
        return courseService.getCoursesByDayAndTime(day, time);
    }
}
