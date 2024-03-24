package com.appl3.cpst3.service; // 이 패키지는 com.appl3.cpst3.service로 정의됨

import org.springframework.beans.factory.annotation.Autowired; // Autowired 어노테이션을 사용하기 위한 import문
import org.springframework.stereotype.Service; // Service 어노테이션을 사용하기 위한 import문
import com.appl3.cpst3.repository.CourseRepository; // CourseRepository를 사용하기 위한 import문
import com.appl3.cpst3.domain.entity.Course; // Course 엔티티를 사용하기 위한 import문
import java.util.List; // List를 사용하기 위한 import문

@Service // Spring의 Service로 정의되는 클래스임을 나타내는 어노테이션
public class CourseService { // CourseService 클래스 선언

    private final CourseRepository courseRepository; // CourseRepository 객체 선언

    @Autowired // 의존성 주입을 위한 Autowired 어노테이션
    public CourseService(CourseRepository courseRepository) { // CourseService 생성자
        this.courseRepository = courseRepository; // 생성자를 통해 주입된 CourseRepository 객체를 초기화
    }
    
    // 전공을 선택해 해당하는 강의들을 조회하는 메서드
    public List<Course> getCoursesByMajor(String major) { // 전공을 받아 해당하는 강의들을 조회하는 메서드
        return courseRepository.findByMajor(major); // CourseRepository를 통해 전공에 해당하는 강의를 조회하고 반환
    }

    // 강의 이름을 입력받아 입력받은 과목을 조회하는 메서드
    public List<Course> getCourseByName(String courseName) { // 강의 이름을 받아 해당하는 강의들을 조회하는 메서드
        return courseRepository.findByName(courseName); // CourseRepository를 통해 강의 이름에 해당하는 강의를 조회하고 반환
    }

    // 수업 요일과 수업 시작 시간을 선택해 해당 시간에 해당하는 강의를 조회하는 메서드
    public List<Course> getCoursesByDayAndTime(String day, String timeStart) { // 수업 요일과 시작 시간을 받아 해당하는 강의들을 조회하는 메서드
        return courseRepository.findByDayAndTime(day, timeStart); // CourseRepository를 통해 요일과 시작 시간에 해당하는 강의를 조회하고 반환
    }
}
