package ru.oorzhak.authservice.service;

import org.aspectj.lang.annotation.Before;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import ru.oorzhak.authservice.model.User;
import ru.oorzhak.authservice.repository.UserRepository;

public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    private UserService userService;

    @Before("")
    public void init() {
        User user = new User();

//        Mockito
//                .when(userRepository.findById(user.getId()).)
//                .thenReturn(user);
    }
}
