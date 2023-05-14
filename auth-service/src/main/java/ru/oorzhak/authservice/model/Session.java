package ru.oorzhak.authservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("session")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Session implements Serializable {
    @Id
    private String id;
    @NotNull
    private Long userId;
}
