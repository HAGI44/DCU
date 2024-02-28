package com.sugangbk.rest.repository;

import com.sugangbk.rest.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByCode(Integer code);
}
