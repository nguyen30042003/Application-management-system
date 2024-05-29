package com.example.projectcv.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class RecruitmentDetailKeyDTO {
    Long recruitId;
    Long nomineeId;
}
