package com.example.projectcv.dto.request;

import com.example.projectcv.entity.Enterprise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@Getter
@Setter
public class RecruitmentInformationDTO {
    private Timestamp time;
    private Long enterpriseID;
}
