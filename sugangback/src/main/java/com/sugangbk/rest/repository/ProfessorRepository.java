package com.sugangbk.rest.repository;

import com.sugangbk.rest.entity.member.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("select p from Professor p where p.memberInfo.loginId = :loginId")
    List<Professor> findAllByLoginId(@Param("loginId") String loginId);
}
