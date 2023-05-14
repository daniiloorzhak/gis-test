package ru.oorzhak.authservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.oorzhak.authservice.dto.UserDTO;
import ru.oorzhak.authservice.model.User;
import ru.oorzhak.authservice.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.login(userDTO));
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> registerUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @GetMapping
    public ResponseEntity<Long> getUserIdFromSession(@CookieValue(value = "session-id") @NotBlank String sessionId) {
        return null;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello from auth-service");
    }
}
