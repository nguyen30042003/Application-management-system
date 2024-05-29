package com.example.projectcv.services;

import com.example.projectcv.dto.request.RecruitmentInformationDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.RecruitmentInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecruitmentInformationService {
    Page<RecruitmentInformation> getRecruitmentInformation(Pageable pageable);
    ApiResponse<RecruitmentInformation> getByID(Long id);
    ApiResponse<RecruitmentInformation> update(Long id, RecruitmentInformationDTO recruitmentInformationDTO);
    ApiResponse<RecruitmentInformation> create(RecruitmentInformationDTO recruitmentInformationDTO);
    void delete(Long id);
}
