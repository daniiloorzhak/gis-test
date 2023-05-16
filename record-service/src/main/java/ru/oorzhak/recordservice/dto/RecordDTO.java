package ru.oorzhak.recordservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RecordDTO {
    @NotBlank
    private String name;
}
