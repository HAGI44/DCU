package com.appl3.cpst3.repository; // 이 패키지는 com.appl3.cpst3.repository로 정의됨

import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository를 사용하기 위한 import문
import com.appl3.cpst3.domain.entity.User; // User 엔티티를 사용하기 위한 import문
import java.util.Optional; // Optional을 사용하기 위한 import문

public interface UserRepository extends JpaRepository<User, Long> { // User 엔티티에 대한 JpaRepository를 상속하는 UserRepository 인터페이스

    // loginId로 사용자 존재 여부를 확인하는 메서드
    boolean existsByStudentCode(String studentCode); // 학번을 받아 해당 사용자가 존재하는지 여부를 확인하는 메서드

    // 닉네임으로 사용자 존재 여부를 확인하는 메서드는 제거

    // loginId로 사용자를 찾는 메서드
    Optional<User> findByStudentCode(String studentCode); // 학번을 받아 해당 사용자를 조회하는 메서드
}
