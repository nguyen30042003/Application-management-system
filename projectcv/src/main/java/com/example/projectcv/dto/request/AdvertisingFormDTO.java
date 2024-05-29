package com.example.projectcv.dto.request;

import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.entity.Type;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdvertisingFormDTO {
    private Type type;
    private Timestamp recruitmentTime;
    private Long recruitmentInformationID;
}
