package ru.oorzhak.authservice.service;

import reactor.core.publisher.Mono;
import ru.oorzhak.authservice.dto.UserDTO;
import ru.oorzhak.authservice.model.User;

public interface UserService {
    String login(UserDTO userDTO);
    Mono<User> save(UserDTO userDTO);
    Long getUserIdBySessionId(String sessionId);
}
