package ru.oorzhak.recordservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "records")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    private Long id;
    @NotNull
    private Long userId;
    @NotBlank
    private String name;
}

