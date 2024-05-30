package com.example.projectcv.dto.request;

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
    Set<RecruitmentDetailDTO> nominees;
    AdvertisingFormDTO advertisingForm;
    PaymentDTO payment;
}
