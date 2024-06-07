package com.example.projectcv.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class ReportDetailDTO {
    @NotNull(message = "Set potential cannot be null")
    boolean isPotential;
    @NotNull(message = "Set greate potential cannot be null")
    boolean isGreatPotential;
    @NotNull(message = "Strategy cannot be null")
    String strategy;
    @NotNull(message = "Enterprise not null")
    long enterpriseId;
}
