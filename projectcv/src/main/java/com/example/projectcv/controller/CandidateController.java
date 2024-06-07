package com.example.projectcv.controller;

import com.example.projectcv.dto.request.ApplicationFormDTO;
import com.example.projectcv.dto.response.application_response.ApplicationResponse;
import com.example.projectcv.services.CandidateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
@AllArgsConstructor
public class CandidateController {
    private CandidateService candidateService;

    @PostMapping("/{id}/applications")
    public ApplicationResponse createApplication(@PathVariable long id,
                                                 @RequestBody ApplicationFormDTO applicationProfileDTO)
    {
        return candidateService.createApplication(id,applicationProfileDTO);
    }
}
