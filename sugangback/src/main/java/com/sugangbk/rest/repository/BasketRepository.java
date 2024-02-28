package com.sugangbk.rest.repository;

import com.sugangbk.rest.entity.Basket;
import com.sugangbk.rest.entity.member.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Page<Basket> findAllByStudent(Student student, Pageable pageable);
}
