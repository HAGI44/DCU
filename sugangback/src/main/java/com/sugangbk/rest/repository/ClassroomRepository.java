package com.sugangbk.rest.repository;

import com.sugangbk.rest.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    List<Classroom> findAllByCode(Integer code);

    List<Classroom> findAllByActivatedTrue();
}
