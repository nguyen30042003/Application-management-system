package com.example.projectcv.services;

import com.example.projectcv.dto.request.EnterpriseRequest;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Enterprise;

public interface EnterpriseService {
    Enterprise create(EnterpriseRequest enterpriseRequest);
    ApiResponse<Enterprise> getById(Long id);
}
