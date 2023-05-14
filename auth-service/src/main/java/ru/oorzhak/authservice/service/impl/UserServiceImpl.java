package ru.oorzhak.authservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.oorzhak.authservice.dto.UserDTO;
import ru.oorzhak.authservice.exception.UserNotFoundException;
import ru.oorzhak.authservice.model.Session;
import ru.oorzhak.authservice.model.User;
import ru.oorzhak.authservice.repository.SessionRepository;
import ru.oorzhak.authservice.repository.UserRepository;
import ru.oorzhak.authservice.service.UserService;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public String login(UserDTO userDTO) {
        User user = userRepository.findByLogin(userDTO.getLogin()).blockOptional().orElseThrow();
        if (Objects.equals(userDTO.getPassword(), user.getPassword())) {
            throw new UserNotFoundException();
        }

        Session session = sessionRepository.findByUserId(user.getId());

        if (session == null) {
            session = Session.builder()
                    .userId(user.getId())
                    .build();
            sessionRepository.save(session);
        }
        return session.getId();
    }

    @Override
    public Mono<User> save(UserDTO userDTO) {
        return userRepository.save(mapDTO(userDTO));
    }

    private User mapDTO(UserDTO userDTO) {
        return User.builder()
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .build();
    }
}
