package com.example.projectcv.dto.response.report_response;

import com.example.projectcv.dto.response.recruitment_response.EnterpriseResponse;
import lombok.Data;

@Data
public class ReportDetailResponse {
    boolean is_greate_potential;
    boolean is_potential;
    EnterpriseResponse enterpriseResponse = new EnterpriseResponse();
    String strategy;
}
