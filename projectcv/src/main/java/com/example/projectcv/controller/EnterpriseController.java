package com.example.projectcv.controller;


import com.example.projectcv.dto.request.EnterpriseRequest;
import com.example.projectcv.dto.request.RecruitmentInformationDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Enterprise;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.services.EnterpriseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enterprises")
@AllArgsConstructor
public class EnterpriseController {
    private EnterpriseService enterpriseService;

    @PostMapping()
    public ApiResponse<Enterprise> create(@Valid @RequestBody EnterpriseRequest enterpriseRequest) {
        ApiResponse<Enterprise> apiResponse = new ApiResponse<>();
        apiResponse.setData(enterpriseService.create(enterpriseRequest));
        return apiResponse;
    }
    @PostMapping("/{id}/recruitment")
    public ApiResponse<RecruitmentInformation> createRecruitment(
            @PathVariable Long id,
            @Valid @RequestBody RecruitmentInformationDTO recruitmentCreationDTO){

        return enterpriseService.createRecruitment(id, recruitmentCreationDTO);

    }
}
