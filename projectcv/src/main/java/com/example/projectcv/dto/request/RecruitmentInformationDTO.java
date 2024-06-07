package com.example.projectcv.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@Getter
@Setter
public class RecruitmentInformationDTO {
    @Valid
    @NotNull(message = "Nominees cannot be null")
    private Set<RecruitmentDetailDTO> nominees;

    @NotNull(message = "Advertising cannot be null")
    private String advertisingType;

    @NotNull(message = "Advertising cannot be null")
    private boolean isFullPayment;

    @NotNull(message = "Payment tyoe cannot be null")
    private String typePayment;

    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Amount must be greater than or equal to zero")
    @Digits(integer = 10, fraction = 2, message = "Amount must be a valid monetary amount with up to 10 integer digits and 2 fraction digits")
    private BigDecimal amount;

    @Positive(message = "Number of days to apply for job posting must be a positive number")
    private int time;

}
