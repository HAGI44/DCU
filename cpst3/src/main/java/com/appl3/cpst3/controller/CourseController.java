package com.appl3.cpst3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.appl3.cpst3.domain.entity.Course;
import com.appl3.cpst3.service.CourseService;
import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // 전공을 선택해 해당하는 강의들을 조회하는 메서드
    @GetMapping("/courses/major/{major}")
    public List<Course> getCoursesByMajor(@PathVariable String major) {
        return courseService.getCoursesByMajor(major);
    }

    // 강의 이름을 입력받아 입력받은 과목을 조회하는 메서드
    @GetMapping("/courses/name/{courseName}")
    public List<Course> getCourseByName(@PathVariable String courseName) {
        return courseService.getCourseByName(courseName);
    }

    // 수업 요일과 수업 시작 시간을 선택해 해당 시간에 해당하는 강의를 조회하는 메서드
    @GetMapping("/courses/day/{day}/time/{timeStart}")
    public List<Course> getCoursesByDayAndTime(@PathVariable String day, @PathVariable String timeStart) {
        return courseService.getCoursesByDayAndTime(day, timeStart);
    }
}
