package com.example.projectcv.controller;


import com.example.projectcv.dto.request.EnterpriseRequest;
import com.example.projectcv.dto.request.RecruitmentInformationDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Enterprise;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.services.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enterprises")
@AllArgsConstructor
public class EnterpriseController {
    private EnterpriseService enterpriseService;

    @PostMapping()
    public ApiResponse<Enterprise> create(@RequestBody EnterpriseRequest enterpriseRequest) {
        ApiResponse<Enterprise> apiResponse = new ApiResponse<>();
        apiResponse.setData(enterpriseService.create(enterpriseRequest));
        return apiResponse;
    }
    @PostMapping("/{id}/recruitment")
    public ApiResponse<RecruitmentInformation> createRecruitment(
            @PathVariable Long id,
            @RequestBody RecruitmentInformationDTO recruitmentCreationDTO){

        return enterpriseService.createRecruitment(id, recruitmentCreationDTO);

    }
}
