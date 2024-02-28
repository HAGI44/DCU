package com.sugangbk.rest.service;

import com.sugangbk.rest.entity.Classroom;
import com.sugangbk.rest.entity.Course.Course;
import com.sugangbk.rest.entity.Course.CourseTime;
import com.sugangbk.rest.entity.Course.Day;
import com.sugangbk.rest.entity.Department;
import com.sugangbk.rest.entity.member.Professor;
import com.sugangbk.rest.exception.exception.NotAuthorizedException;
import com.sugangbk.rest.repository.CourseRepository;
import com.sugangbk.rest.service.dto.CourseOpenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public Course open(CourseOpenDTO courseOpenDTO) {
        if (isDuplicatedCourseTimeAndClassroom(courseOpenDTO.getCourseTime(), courseOpenDTO.getClassroom()))
            throw new RuntimeException("선택한 교실과 시간이 다른 코스와 겹칩니다.");

        Course course = modelMapper.map(courseOpenDTO, Course.class);

        return courseRepository.save(course);
    }

    public void close(Course course, Professor professor) {
        if (!course.getProfessor().equals(professor))
            throw new NotAuthorizedException();

        course.setActivated(false);
    }

    public void addProhibitedDepartment(Course course, Department department, Professor professor) {
        if (!course.getProfessor().equals(professor))
            throw new NotAuthorizedException();
        if (course.getProhibitedDepartments().stream().anyMatch(e -> e.equals(department)))
            return;

        course.getProhibitedDepartments().add(department);
    }

    private boolean isDuplicatedCourseTimeAndClassroom(CourseTime courseTime, Classroom classroom) {

        final Day day = courseTime.getDay();
        final Integer startHour = courseTime.getStartHour();
        final Integer endHour = courseTime.getEndHour();

        List<Course> allCourseByDay = courseRepository.findAllCourseByDay(day);

        return allCourseByDay.stream()
                .filter(Course::getActivated)
                .filter(e -> e.getClassroom().equals(classroom))
                .map(Course::getCourseTime)
                .anyMatch(e -> e.getStartHour() <= startHour && startHour < e.getEndHour()
                        || e.getStartHour() < endHour && endHour <= e.getEndHour()
                        || startHour <= e.getStartHour() && e.getStartHour() < endHour
                        || startHour < e.getEndHour() && e.getEndHour() <= endHour);
    }
}
