package com.sugangbk.rest.entity;

import com.sugangbk.rest.entity.Course.Course;
import com.sugangbk.rest.entity.member.Student;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment  {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    Student student;

    @Setter
    private boolean onSemester = true;

    @Setter
    private ScoreType scoreType;

    @Builder
    private Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;
        course.getEnrollments().add(this);
        student.getEnrollments().add(this);
    }
}
