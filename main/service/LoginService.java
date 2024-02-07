package artifact.service;

import artifact.domain.User;
import artifact.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public User login(String loginId, String pwd) {
        return userRepository.findByUid(loginId)
                .filter(m -> m.getPwd().equals(pwd))
                .orElse(null);
    }
}