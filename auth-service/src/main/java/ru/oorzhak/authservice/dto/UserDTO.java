package ru.oorzhak.authservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
