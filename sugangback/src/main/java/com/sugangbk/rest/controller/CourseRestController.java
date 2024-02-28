package com.sugangbk.rest.controller;

import com.sugangbk.rest.aop.annotation.PermitAnyLogin;
import com.sugangbk.rest.aop.annotation.PermitProfessor;
import com.sugangbk.rest.controller.request.CourseOpenRequest;
import com.sugangbk.rest.controller.response.CourseResponse;
import com.sugangbk.rest.entity.Classroom;
import com.sugangbk.rest.entity.Course.Course;
import com.sugangbk.rest.entity.Department;
import com.sugangbk.rest.entity.Subject;
import com.sugangbk.rest.entity.member.Professor;
import com.sugangbk.rest.exception.exception.NoExistEntityException;
import com.sugangbk.rest.repository.*;
import com.sugangbk.rest.service.CourseService;
import com.sugangbk.rest.service.dto.CourseOpenDTO;
import com.sugangbk.rest.session.SessionConst;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
@Transactional
public class CourseRestController {

    private final CourseService courseService;

    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private final DepartmentRepository departmentRepository;
    private final ProfessorRepository professorRepository;
    private final ClassroomRepository classroomRepository;

    @PermitProfessor
    @PostMapping("/open")
    public void openCourse(
            @Parameter(hidden = true) @SessionAttribute(name = SessionConst.LOGIN_PROFESSOR, required = false) Long professorId,
            @RequestBody @Valid CourseOpenRequest courseOpenRequest
    ) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(NoExistEntityException::new);
        Subject subject = subjectRepository.findById(courseOpenRequest.getSubjectId())
                .orElseThrow(NoExistEntityException::new);
        Department department = departmentRepository.findById(courseOpenRequest.getDepartmentId())
                .orElseThrow(NoExistEntityException::new);
        List<Department> prohibitedDepartments = courseOpenRequest.getProhibitedDepartmentIds().stream()
                .map(e -> departmentRepository.findById(e).orElseThrow(NoExistEntityException::new))
                .collect(Collectors.toList());
        Classroom classroom = classroomRepository.findById(courseOpenRequest.getClassroomId())
                .orElseThrow(NoExistEntityException::new);

        CourseOpenDTO courseOpenDTO = CourseOpenDTO.builder()
                .subject(subject)
                .department(department)
                .professor(professor)
                .courseTime(courseOpenRequest.getCourseTime())
                .capacity(courseOpenRequest.getCapacity())
                .openSemester(courseOpenRequest.getOpenSemester())
                .openYear(courseOpenRequest.getOpenYear())
                .division(courseOpenRequest.getDivision())
                .classroom(classroom)
                .studentYear(courseOpenRequest.getStudentYear())
                .prohibitedDepartments(prohibitedDepartments)
                .build();

        courseService.open(courseOpenDTO);
    }

    @PermitProfessor
    @PostMapping("/close")
    @Valid
    public void close(
            @Parameter(hidden = true) @SessionAttribute(name = SessionConst.LOGIN_PROFESSOR, required = false) Long professorId,
            @RequestParam @NotNull Long courseId
    ) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(NoExistEntityException::new);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(NoExistEntityException::new);

        courseService.close(course, professor);
    }

    @PermitProfessor
    @PostMapping("/prohibit-dept")
    @Valid
    void prohibitDept(
            @Parameter(hidden = true) @SessionAttribute(name = SessionConst.LOGIN_PROFESSOR, required = false) Long professorId,
            @RequestParam @NotNull Long courseId,
            @RequestParam @NotNull Long departmentId
    ) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(NoExistEntityException::new);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(NoExistEntityException::new);
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(NoExistEntityException::new);

        courseService.addProhibitedDepartment(course, department, professor);
    }

    @PermitAnyLogin
    @PostMapping("/list")
    public Page<CourseResponse> courseList(Pageable pageable) {
        return courseRepository.findAllActivated(pageable)
                .map(CourseResponse::new);
    }

    @PermitAnyLogin
    @PostMapping("/professor/list")
    public Page<CourseResponse> courseList(
            @Parameter(hidden = true) @SessionAttribute(name = SessionConst.LOGIN_PROFESSOR, required = false) Long professorId,
            Pageable pageable) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(NoExistEntityException::new);

        return courseRepository.findAllByProfessorAndActivatedTrue(professor, pageable)
                .map(CourseResponse::new);
    }
}
