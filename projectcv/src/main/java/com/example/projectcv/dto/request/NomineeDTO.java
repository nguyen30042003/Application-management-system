package com.example.projectcv.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class NomineeDTO {
    @NotNull(message = "Nominee description cannot be null")
    private String description;
    @NotNull(message = "Nominee name cannot be null")
    private String name;
}
