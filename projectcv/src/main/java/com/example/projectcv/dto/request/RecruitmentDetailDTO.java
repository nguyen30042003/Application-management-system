package com.example.projectcv.dto.request;

import com.example.projectcv.entity.Nominee;
import com.example.projectcv.entity.RecruitmentInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class RecruitmentDetailDTO {
    private int quantity;
    private String requestedInfo;
    private Long recruitmentInformationId;
    private Long nomineeId;
}
