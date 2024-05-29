package com.example.projectcv.controller;


import com.example.projectcv.dto.request.AdvertisingFormDTO;
import com.example.projectcv.dto.request.RecruitmentInformationDTO;
import com.example.projectcv.dto.request.UpdateAdvertisingFormDTO;
import com.example.projectcv.dto.request.UpdateRecruitmentDetailDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.AdvertisingForm;
import com.example.projectcv.entity.RecruitmentDetail;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.services.AdvertisingFormService;
import com.example.projectcv.services.RecruitmentInformationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/advertisingForm")
public class AdvertisingFormController {
    private AdvertisingFormService advertisingFormService;

    @PostMapping()
    public ApiResponse<AdvertisingForm> signUp(@RequestBody AdvertisingFormDTO advertisingFormDTO) {
        return advertisingFormService.create(advertisingFormDTO);
    }

    @PutMapping()
    public ApiResponse<AdvertisingForm> update(@RequestBody UpdateAdvertisingFormDTO updateAdvertisingFormDTO) {
        return advertisingFormService.update(updateAdvertisingFormDTO);
    }
}
