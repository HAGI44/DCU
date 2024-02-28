package artifact.service;

import artifact.domain.User;
import artifact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String loginId, String pwd) {
        return userRepository.findByUid(loginId)
                .filter(m -> m.getPwd().equals(pwd))
                .orElse(null);
    }
}