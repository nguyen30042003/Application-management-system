package com.example.projectcv.dto.request;

import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdvertisingFormKeyDTO {
    Long recruitmentId;
    Timestamp recruitmentTime;
}
