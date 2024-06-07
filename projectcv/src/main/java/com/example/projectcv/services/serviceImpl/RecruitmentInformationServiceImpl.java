package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.dto.response.recruitment_response.EnterpriseResponse;
import com.example.projectcv.dto.response.nominee_response.NomineeResponse;
import com.example.projectcv.dto.response.recruitment_response.RecruitmentsResponse;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.repository.RecruitmentInformationRepository;
import com.example.projectcv.services.RecruitmentInformationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RecruitmentInformationServiceImpl implements RecruitmentInformationService {

    RecruitmentInformationRepository recruitmentInformationRepository;
    
    @Override
    public Page<RecruitmentsResponse> getRecruitmentInformation(Pageable pageable) {
        Page<RecruitmentInformation> 
                recruitmentInformation = recruitmentInformationRepository.findAll(pageable);

        List<RecruitmentInformation> recruitmentInformations = recruitmentInformation.getContent();
        List<RecruitmentsResponse> recruitmentsResponses = new ArrayList<>();
        for (RecruitmentInformation recruitmentInformation1 : recruitmentInformations) {
            RecruitmentsResponse recruitmentsResponse = getRecruitmentResponse(recruitmentInformation1);
            recruitmentsResponses.add(recruitmentsResponse);

        }

        return new PageImpl<>(recruitmentsResponses,pageable,recruitmentsResponses.size());

    }
    
    private static RecruitmentsResponse getRecruitmentResponse(RecruitmentInformation recruitmentInformation) {
        RecruitmentsResponse  recruitmentsResponse = new RecruitmentsResponse(); 
        recruitmentsResponse.setId(recruitmentInformation.getId());
        recruitmentsResponse.setTime(recruitmentInformation.getTime());
        List<NomineeResponse> nomineeResponses = new ArrayList<>();
        for (var detail : recruitmentInformation.getRecruitmentDetails() ) {
            NomineeResponse nomineeResponse = new NomineeResponse();
            nomineeResponse.setRequestInfo(detail.getRequestedInfo());
            nomineeResponse.setNomineeId(detail.getNominee().getId());
            nomineeResponse.setQuantity(detail.getQuantity());
            nomineeResponse.setNomineeName(detail.getNominee().getName());
            nomineeResponses.add(nomineeResponse);
            
        }
        recruitmentsResponse.setNominees(nomineeResponses);
        EnterpriseResponse enterpriseResponse = getEnterpriseResponse(recruitmentInformation);

        recruitmentsResponse.setEnterprise(enterpriseResponse);
        return recruitmentsResponse;
    }

    private static EnterpriseResponse getEnterpriseResponse(RecruitmentInformation recruitmentInformation) {
        EnterpriseResponse enterpriseResponse = new EnterpriseResponse();
        enterpriseResponse.setEnterPriseName(recruitmentInformation.getEnterprise().getName());
        enterpriseResponse.setEnterPriseId(recruitmentInformation.getEnterprise().getId());
        enterpriseResponse.setContact(recruitmentInformation.getEnterprise().getContact());
        enterpriseResponse.setEnterPriseEmail(recruitmentInformation.getEnterprise().getEmail());
        enterpriseResponse.setEnterPriseAddress(recruitmentInformation.getEnterprise().getAddress());
        return enterpriseResponse;
    }

    @Override
    public ApiResponse<RecruitmentInformation> getByID(Long id) {
        return null;
    }
}
