package artifact;

import artifact.domain.User;
import artifact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestDataInit {

    private final UserService userService;

    @Autowired
    public TestDataInit(UserService userService) {
        this.userService = userService;
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {

        /**
         * 테스트 유저 추가
         */
        User userA = new User();
        userA.setUid("Test1");
        userA.setPwd("qwer1234");
        userA.setName("곽득춘");

        userService.join(userA);
    }
}
