package com.example.projectcv.dto.response.recruitment_response;

import lombok.Data;

@Data
public class NomineeResponse {
    long nomineeId;
    String nomineeName;
    String requestInfo;
    int quantity;
}
