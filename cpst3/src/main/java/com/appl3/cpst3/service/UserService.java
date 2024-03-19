package com.appl3.cpst3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appl3.cpst3.domain.dto.LoginRequest;
import com.appl3.cpst3.domain.entity.User;
import com.appl3.cpst3.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * loginId 중복 체크
     */
    public boolean checkLoginIdDuplicate(String studentCode) {
        return userRepository.existsByStudentCode(studentCode);
    }

    /**
     * 회원가입 기능은 제외

    /**
     * 로그인 기능
     */
    public User login(LoginRequest req) {
        Optional<User> optionalUser = userRepository.findByStudentCode(req.getLoginId());

        // loginId와 일치하는 User가 없으면 null return
        if(optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        // 찾아온 User의 password와 입력된 password가 다르면 null return
        if(!user.getPassword().equals(req.getPassword())) {
            return null;
        }

        return user;
    }

    /**
     * userId(Long)를 입력받아 User을 return 해주는 기능
     */
    public User getLoginUserById(Long userId) {
        if(userId == null) return null;

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }

    /**
     * loginId(String)를 입력받아 User을 return 해주는 기능
     */
    public User getLoginUserByLoginId(String studentCode) {
        if(studentCode == null) return null;

        Optional<User> optionalUser = userRepository.findByStudentCode(studentCode);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }
}
