package com.example.projectcv.dto.response.recruitment_response;

import lombok.Data;

@Data
public class ReportDetailRespone {
    boolean is_greate_potential;
    boolean is_potential;
    EnterpriseResponse enterpriseResponse = new EnterpriseResponse();
    String strategy;
}
