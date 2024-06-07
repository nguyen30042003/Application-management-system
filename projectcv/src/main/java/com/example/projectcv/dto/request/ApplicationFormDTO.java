package com.example.projectcv.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ApplicationFormDTO {
    @Min(value = 1, message = "Recruit ID must be greater than or equal to 1")
    private long recruitId;

    @Min(value = 1, message = "Nominee ID must be greater than or equal to 1")
    private long nomineeId;

}
