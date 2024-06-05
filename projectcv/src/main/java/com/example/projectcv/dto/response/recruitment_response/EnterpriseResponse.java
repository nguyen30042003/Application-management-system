package com.example.projectcv.dto.response.recruitment_response;

import lombok.Data;

import java.util.Date;

@Data
public class EnterpriseResponse {
    long enterPriseId;
    String enterPriseName;
    String contact;
    String enterPriseEmail;
    String tax;
    Date dateOfExpiration;
    String enterPriseAddress;
}
