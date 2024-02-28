package com.sugangbk.rest.repository;

import com.sugangbk.rest.entity.member.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.memberInfo.loginId = :loginId")
    List<Student> findAllByLoginId(@Param("loginId") String loginId);
}
