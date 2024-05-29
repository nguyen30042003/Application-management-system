package com.example.projectcv.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateRecruitmentDetailDTO {
    private RecruitmentDetailDTO recruitmentDetailDTO;
    private RecruitmentDetailKeyDTO recruitmentDetailKeyDTO;
}