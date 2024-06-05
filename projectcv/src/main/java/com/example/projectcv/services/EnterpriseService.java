package com.example.projectcv.services;

import com.example.projectcv.dto.request.EnterpriseRequest;
import com.example.projectcv.dto.request.RecruitmentInformationDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.dto.response.recruitment_response.EnterpriseResponse;
import com.example.projectcv.dto.response.recruitment_response.RecruitmentsResponse;
import com.example.projectcv.entity.Enterprise;
import com.example.projectcv.entity.RecruitmentInformation;

public interface EnterpriseService {
    EnterpriseResponse create(EnterpriseRequest enterpriseRequest);
    EnterpriseResponse getById(Long id);
    RecruitmentsResponse createRecruitment(Long id, RecruitmentInformationDTO recruitmentCreationDTO);
}
