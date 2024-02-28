package com.sugangbk.rest.entity;

import com.sugangbk.rest.entity.Course.Course;
import com.sugangbk.rest.entity.member.Student;
import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Course course;

    @Builder
    private Basket(Student student, Course course){
        this.student = student;
        this.course = course;
        student.getBaskets().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Basket basket = (Basket) o;
        return Objects.equals(id, basket.id) && Objects.equals(student, basket.student) && Objects.equals(course, basket.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, course);
    }
}
