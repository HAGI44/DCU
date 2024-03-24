package com.appl3.cpst3.service; // com.appl3.cpst3.service 패키지 정의

import lombok.RequiredArgsConstructor; // RequiredArgsConstructor 어노테이션을 사용하기 위한 import문
import org.springframework.stereotype.Service; // Service 어노테이션을 사용하기 위한 import문
import org.springframework.transaction.annotation.Transactional; // Transactional 어노테이션을 사용하기 위한 import문
import com.appl3.cpst3.domain.dto.LoginRequest; // LoginRequest DTO를 사용하기 위한 import문
import com.appl3.cpst3.domain.entity.User; // User 엔티티를 사용하기 위한 import문
import com.appl3.cpst3.repository.UserRepository; // UserRepository를 사용하기 위한 import문

import java.util.Optional; // Optional 클래스를 사용하기 위한 import문

@Service // Spring의 Service로 정의되는 클래스임을 나타내는 어노테이션
@Transactional // 트랜잭션 처리를 위한 Transactional 어노테이션
@RequiredArgsConstructor // 필수 생성자를 생성하기 위한 RequiredArgsConstructor 어노테이션
public class UserService { // UserService 클래스 선언

    private final UserRepository userRepository; // UserRepository 객체 선언

    /**
     * loginId 중복 체크
     */
    public boolean checkLoginIdDuplicate(String studentCode) { // loginId 중복을 체크하는 메서드
        return userRepository.existsByStudentCode(studentCode); // UserRepository를 통해 loginId가 존재하는지 확인하여 결과 반환
    }

    /**
     * 회원가입 기능은 제외됨
     */

    /**
     * 로그인 기능
     */
    public User login(LoginRequest req) { // 로그인 기능을 수행하는 메서드
        Optional<User> optionalUser = userRepository.findByStudentCode(req.getLoginId()); // UserRepository를 통해 loginId로 사용자 조회
        
        // 사용자가 존재하지 않으면 null 반환
        if (optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get(); // Optional에서 User 객체 가져오기

        // 입력된 비밀번호와 사용자의 비밀번호가 일치하지 않으면 null 반환
        if (!user.getPassword().equals(req.getPassword())) {
            return null;
        }

        return user; // 유효한 사용자 객체 반환
    }

    /**
     * userId(Long)를 입력받아 User을 return 해주는 기능
     */
    public User getLoginUserById(Long userId) { // userId를 기반으로 사용자를 조회하여 반환하는 메서드
        // userId가 null이면 null 반환
        if (userId == null) return null;

        Optional<User> optionalUser = userRepository.findById(userId); // UserRepository를 통해 userId로 사용자 조회
        // 조회된 사용자가 없으면 null 반환
        if (optionalUser.isEmpty()) return null;

        return optionalUser.get(); // 조회된 사용자 객체 반환
    }

    /**
     * loginId(String)를 입력받아 User을 return 해주는 기능
     */
    public User getLoginUserByLoginId(String studentCode) { // loginId를 기반으로 사용자를 조회하여 반환하는 메서드
        // loginId가 null이면 null 반환
        if (studentCode == null) return null;

        Optional<User> optionalUser = userRepository.findByStudentCode(studentCode); // UserRepository를 통해 loginId로 사용자 조회
        // 조회된 사용자가 없으면 null 반환
        if (optionalUser.isEmpty()) return null;

        return optionalUser.get(); // 조회된 사용자 객체 반환
    }
}
