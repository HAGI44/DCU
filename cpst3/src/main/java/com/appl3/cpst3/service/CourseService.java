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
        // CourseRepository에서 전공에 해당하는 강의들을 조회하는 메서드를 호출하여 사용
        return courseRepository.findByMajor(major);
    }

    // 강의 이름을 입력받아 입력받은 과목을 조회하는 메서드
    public Course getCourseByName(String courseName) {
        // CourseRepository에서 강의 이름으로 조회하는 메서드를 호출하여 사용
        List<Course> courses = courseRepository.findByName(courseName);
        if (!courses.isEmpty()) {
            return courses.get(0);
        } else {
            return null;
        }
    }

    // 요일과 수업 시간을 선택해 해당 시간에 해당하는 강의를 조회하는 메서드
    public List<Course> getCoursesByDayAndTime(String day, String time) {
        // CourseRepository에서 요일과 수업 시간에 해당하는 강의를 조회하는 메서드를 호출하여 사용
        return courseRepository.findByDayOfWeekAndClassTime(day, time);
    }
}
