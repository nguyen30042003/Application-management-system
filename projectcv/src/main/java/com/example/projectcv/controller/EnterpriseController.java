package com.example.projectcv.controller;


import com.example.projectcv.dto.request.EnterpriseRequest;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Enterprise;
import com.example.projectcv.services.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise")
@AllArgsConstructor
public class EnterpriseController {
    private EnterpriseService enterpriseService;

    @PostMapping("/create")
    public ApiResponse<Enterprise> create(@RequestBody EnterpriseRequest enterpriseRequest)
    {
        ApiResponse<Enterprise> apiResponse = new ApiResponse<>();
        apiResponse.setData(enterpriseService.create(enterpriseRequest));
        return apiResponse;
    }
}
