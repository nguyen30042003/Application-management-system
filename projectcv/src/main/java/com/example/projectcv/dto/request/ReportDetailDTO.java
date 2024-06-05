package com.example.projectcv.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class ReportDetailDTO {
    @NotNull(message = "Full payment status cannot be null")
    boolean isPotential;
    @NotNull(message = "Full payment status cannot be null")
    boolean isGreatPotential;
    @NotNull(message = "Full payment status cannot be null")
    String strategy;
    @NotNull(message = "Full payment status cannot be null")
    long enterpriseId;
}
