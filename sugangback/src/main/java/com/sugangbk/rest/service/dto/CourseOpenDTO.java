package com.sugangbk.rest.service.dto;

import com.sugangbk.rest.entity.Classroom;
import com.sugangbk.rest.entity.Course.CourseTime;
import com.sugangbk.rest.entity.Department;
import com.sugangbk.rest.entity.Subject;
import com.sugangbk.rest.entity.member.Professor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseOpenDTO {
    private Subject subject;

    private Department department;

    private Integer capacity;

    private Integer studentYear;

    private Integer openYear;

    private Integer openSemester;

    private Integer division;

    private Classroom classroom;

    private Professor professor;

    private CourseTime courseTime;

    private List<Department> prohibitedDepartments;
}
