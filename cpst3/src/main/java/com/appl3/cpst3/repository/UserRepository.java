package com.appl3.cpst3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appl3.cpst3.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // loginId로 사용자 존재 여부를 확인하는 메서드
    boolean existsByStudentCode(String studentCode);

    // 닉네임으로 사용자 존재 여부를 확인하는 메서드는 제거

    // loginId로 사용자를 찾는 메서드
    Optional<User> findByStudentCode(String studentCode);
}
