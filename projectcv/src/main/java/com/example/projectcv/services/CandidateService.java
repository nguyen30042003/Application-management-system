package com.example.projectcv.services;

import com.example.projectcv.dto.request.ApplicationFormDTO;
import com.example.projectcv.dto.response.application_response.ApplicationResponse;

public interface CandidateService {

    ApplicationResponse createApplication(long id, ApplicationFormDTO applicationProfileDTO);
}
