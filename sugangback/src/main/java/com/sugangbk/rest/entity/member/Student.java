package com.sugangbk.rest.entity.member;

import com.sugangbk.rest.entity.*;
import lombok.*;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student  {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private MemberInfo memberInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    @Builder.Default
    private List<Enrollment> enrollments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    @Builder.Default
    private List<Basket> baskets = new ArrayList<>();
}
