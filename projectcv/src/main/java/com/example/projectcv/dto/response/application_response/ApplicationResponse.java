package com.example.projectcv.dto.response.application_response;

import lombok.Data;

@Data
public class ApplicationResponse {
    private long recruitId;
    private long nomineeId;
    private long candidateId;
    private boolean isProcessed;
    private boolean isResponded;

}
