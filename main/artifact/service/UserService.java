/**package artifact.service;

import artifact.domain.User;
import artifact.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Long join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateUser(User user) {
        Optional<User> findUsers = userRepository.findByUid(user.getUid());
        if (findUsers.isPresent()) {
            throw new IllegalStateException("Already Existing User");
        }
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }

    public User findOne(Long userId){
        return userRepository.findOne(userId);
    }
}
*
*/
