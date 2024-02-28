package com.sugangbk.rest.entity;

import com.sugangbk.rest.entity.Course.Course;
import lombok.*;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer code;

    @Builder.Default
    @Setter
    private Boolean activated = true;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classroom")
    @Builder.Default
    List<Course> courses = new ArrayList<>();
    
    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public Long getId() {
        return this.id;
    }
}
