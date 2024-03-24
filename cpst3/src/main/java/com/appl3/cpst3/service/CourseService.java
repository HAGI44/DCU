package com.appl3.cpst3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appl3.cpst3.repository.CourseRepository;
import com.appl3.cpst3.domain.entity.Course;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    // 전공을 선택해 해당하는 강의들을 조회하는 메서드
    public List<Course> getCoursesByMajor(String major) {
        return courseRepository.findByMajor(major);
    }

    // 강의 이름을 입력받아 입력받은 과목을 조회하는 메서드
    public List<Course> getCourseByName(String courseName) {
        return courseRepository.findByName(courseName);
    }

    // 수업 요일과 수업 시작 시간을 선택해 해당 시간에 해당하는 강의를 조회하는 메서드
    public List<Course> getCoursesByDayAndTime(String day, String timeStart) {
        return courseRepository.findByDayAndTime(day, timeStart);
    }
}
