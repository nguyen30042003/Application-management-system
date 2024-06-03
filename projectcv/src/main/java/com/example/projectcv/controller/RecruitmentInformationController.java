package com.example.projectcv.controller;



import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.dto.response.recruitment_response.RecruitmentsResponse;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.services.RecruitmentInformationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/recruitments")
public class RecruitmentInformationController {
    private RecruitmentInformationService recruitmentInformationService;

    @GetMapping()
    public Page<RecruitmentsResponse> getAllRecruitmentInformation(Pageable pageable) {
        return recruitmentInformationService.getRecruitmentInformation(pageable);
    }

}
