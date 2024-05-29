package com.example.projectcv.services;

import com.example.projectcv.dto.request.NomineeDTO;
import com.example.projectcv.dto.request.RecruitmentInformationDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Nominee;
import com.example.projectcv.entity.RecruitmentInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NomineeService {
    Page<Nominee> getNominee(Pageable pageable);
    ApiResponse<Nominee> getByID(Long id);
    ApiResponse<Nominee> update(Long id, NomineeDTO nomineeDTO);
    ApiResponse<Nominee> create(NomineeDTO nomineeDTO);
    void delete(Long id);
}
