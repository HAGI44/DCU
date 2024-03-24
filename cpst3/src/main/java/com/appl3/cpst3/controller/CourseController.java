package com.appl3.cpst3.controller; // 이 패키지는 com.appl3.cpst3.controller로 정의되어 있음

import org.springframework.beans.factory.annotation.Autowired; // Spring 프레임워크의 의존성 주입 기능을 사용하기 위한 어노테이션을 가져옴
import org.springframework.web.bind.annotation.*; // Spring 웹 애플리케이션의 REST 컨트롤러를 작성하기 위한 어노테이션을 가져옴
import com.appl3.cpst3.domain.entity.Course; // Course 엔티티 클래스를 가져옴
import com.appl3.cpst3.service.CourseService; // CourseService를 가져옴
import java.util.List; // List 클래스를 가져옴

@RestController // 이 클래스가 REST 컨트롤러임을 선언하는 어노테이션
public class CourseController {
    private final CourseService courseService; // CourseService 의존성을 주입하기 위한 필드

    @Autowired // CourseService의 의존성을 자동으로 주입하기 위한 어노테이션
    public CourseController(CourseService courseService) { // CourseController 생성자
        this.courseService = courseService; // 주입된 CourseService를 이 클래스의 필드에 할당
    }

    // 전공을 선택해 해당하는 강의들을 조회하는 메서드
    @GetMapping("/courses/major/{major}") // HTTP GET 메소드로 "/courses/major/{major}" 경로에 매핑되는 요청을 처리하는 메서드
    public List<Course> getCoursesByMajor(@PathVariable String major) { // 전공을 입력받아 해당하는 강의 리스트를 반환하는 메서드
        return courseService.getCoursesByMajor(major); // CourseService의 getCoursesByMajor 메서드를 호출하여 해당하는 강의 리스트를 반환
    }

    // 강의 이름을 입력받아 입력받은 과목을 조회하는 메서드
    @GetMapping("/courses/name/{courseName}") // HTTP GET 메소드로 "/courses/name/{courseName}" 경로에 매핑되는 요청을 처리하는 메서드
    public List<Course> getCourseByName(@PathVariable String courseName) { // 강의 이름을 입력받아 해당하는 강의 리스트를 반환하는 메서드
        return courseService.getCourseByName(courseName); // CourseService의 getCourseByName 메서드를 호출하여 해당하는 강의 리스트를 반환
    }

    // 수업 요일과 수업 시작 시간을 선택해 해당 시간에 해당하는 강의를 조회하는 메서드
    @GetMapping("/courses/day/{day}/time/{timeStart}") // HTTP GET 메소드로 "/courses/day/{day}/time/{timeStart}" 경로에 매핑되는 요청을 처리하는 메서드
    public List<Course> getCoursesByDayAndTime(@PathVariable String day, @PathVariable String timeStart) { // 수업 요일과 시작 시간을 입력받아 해당하는 강의 리스트를 반환하는 메서드
        return courseService.getCoursesByDayAndTime(day, timeStart); // CourseService의 getCoursesByDayAndTime 메서드를 호출하여 해당하는 강의 리스트를 반환
    }
}
