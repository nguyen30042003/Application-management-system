package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.RecruitmentInformationDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.AdvertisingForm;
import com.example.projectcv.entity.Enterprise;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.repository.RecruitmentInformationRepository;
import com.example.projectcv.services.EnterpriseService;
import com.example.projectcv.services.RecruitmentInformationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RecruitmentInformationServiceImpl implements RecruitmentInformationService {
    private RecruitmentInformationRepository recruitmentInformationRepository;
    private EnterpriseService enterpriseService;
    @Override
    public Page<RecruitmentInformation> getRecruitmentInformation(Pageable pageable) {
        return recruitmentInformationRepository.findAll(pageable);
    }

    @Override
    public ApiResponse<RecruitmentInformation> getByID(Long id) {
        Optional<RecruitmentInformation> recruitmentInformation = recruitmentInformationRepository.findById(id);
        System.out.println(recruitmentInformation.isPresent());
        if(recruitmentInformation.isPresent()) {
            ApiResponse<RecruitmentInformation> apiResponse = new ApiResponse<>();
            apiResponse.setData(recruitmentInformation.get());
            return apiResponse;
        } else {
            throw new RuntimeException("RecruitmentInformation not found");
        }
    }

    @Override
    public ApiResponse<RecruitmentInformation> update(Long id, RecruitmentInformationDTO recruitmentInformationDTO) {
        RecruitmentInformation recruitmentInformation = getByID(id).getData();
        Enterprise enterprise = enterpriseService.getById(recruitmentInformationDTO.getEnterpriseID()).getData();
        recruitmentInformation.setEnterprise(enterprise);
        recruitmentInformation.setTime(recruitmentInformationDTO.getTime());
        recruitmentInformationRepository.saveAndFlush(recruitmentInformation);
        return new ApiResponse<>(recruitmentInformation);
    }

    @Override
    public ApiResponse<RecruitmentInformation> create(RecruitmentInformationDTO recruitmentInformationDTO) {
        RecruitmentInformation recruitmentInformation = new RecruitmentInformation();
        recruitmentInformation.setTime(recruitmentInformationDTO.getTime());

        Enterprise enterprise = enterpriseService.getById(recruitmentInformationDTO.getEnterpriseID()).getData();

        recruitmentInformation.setEnterprise(enterprise);
        recruitmentInformationRepository.saveAndFlush(recruitmentInformation);
        return new ApiResponse<>(recruitmentInformation);
    }

    @Override
    public void delete(Long id) {
        RecruitmentInformation recruitmentInformation = getByID(id).getData();
        recruitmentInformationRepository.delete(recruitmentInformation);
    }
}
