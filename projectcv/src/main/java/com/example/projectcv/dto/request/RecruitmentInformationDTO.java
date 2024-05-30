package com.example.projectcv.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@AllArgsConstructor
@Getter
@Setter
public class RecruitmentInformationDTO {
    @Valid
    @NotNull(message = "Nominees cannot be null")
    private Set<RecruitmentDetailDTO> nominees;

    @Valid
    @NotNull(message = "Advertising form cannot be null")
    private AdvertisingFormDTO advertisingForm;

    @Valid
    @NotNull(message = "Payment cannot be null")
    private PaymentDTO payment;
}
