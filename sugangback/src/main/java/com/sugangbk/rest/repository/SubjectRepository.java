package com.sugangbk.rest.repository;

import com.sugangbk.rest.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByCode(Integer code);

    List<Subject> findAllByActivatedTrue();
}
