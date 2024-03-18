package com.appl3.cpst3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appl3.cpst3.domain.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // 추가적인 메서드가 필요하다면 여기에 작성
}