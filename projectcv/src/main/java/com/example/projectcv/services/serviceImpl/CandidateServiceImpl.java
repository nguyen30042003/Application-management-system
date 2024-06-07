package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.ApplicationFormDTO;
import com.example.projectcv.dto.response.application_response.ApplicationResponse;
import com.example.projectcv.entity.*;
import com.example.projectcv.repository.ApplicationFormRepository;
import com.example.projectcv.repository.CandidateRepository;
import com.example.projectcv.repository.RecruitmentDetailRepository;
import com.example.projectcv.services.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private CandidateRepository candidateRepository;
    private RecruitmentDetailRepository recruitmentDetailRepository;
    private ApplicationFormRepository applicationFormRepository;
    @Override
    @PreAuthorize("#id == authentication.principal.id")
    public ApplicationResponse createApplication(long id, ApplicationFormDTO applicationProfileDTO) {
        Candidate candidate = candidateRepository.findById(id).
                orElseThrow(() ->
                        new RuntimeException("Member not found"));

        RecruitmentDetail  recruitmentDetail =
                recruitmentDetailRepository.findByRecruitIdAndNomineeId(
                        applicationProfileDTO.getRecruitId(),
                        applicationProfileDTO.getNomineeId()
                ).orElseThrow(() -> new RuntimeException("Recruitment detail not found"));

        ApplicationForm  applicationForm = new ApplicationForm();
        applicationForm.setCandidate(candidate);
        applicationForm.setRecruitmentDetail(recruitmentDetail);
        applicationForm.setResponded(false);
        applicationForm.setProcessed(false);
        applicationFormRepository.save(applicationForm);

        ApplicationResponse applicationResponse = new ApplicationResponse();
        applicationResponse.setCandidateId(applicationForm.getCandidate().getId());
        applicationResponse.setNomineeId(
                applicationForm.getRecruitmentDetail().getNominee().getId());
        applicationResponse.setProcessed(false);
        applicationResponse.setRecruitId(
                applicationForm.getRecruitmentDetail().getRecruitmentInformation().getId());
        applicationResponse.setResponded(false);
        return applicationResponse;
    }
}
