package com.example.projectcv.controller;

import com.example.projectcv.dto.request.NomineeDTO;
import com.example.projectcv.dto.request.RecruitmentDetailDTO;
import com.example.projectcv.dto.request.RecruitmentDetailKeyDTO;
import com.example.projectcv.dto.request.UpdateRecruitmentDetailDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Nominee;
import com.example.projectcv.entity.RecruitmentDetail;
import com.example.projectcv.services.RecruitmentDetailService;
import com.example.projectcv.services.serviceImpl.NomineeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/recruitmentDetail")
public class RecruitmentDetailController {
    private RecruitmentDetailService recruitmentDetailService;

    @GetMapping()
    public Page<RecruitmentDetail> getAllRecruitmentDetail(Pageable pageable) {
        return recruitmentDetailService.getRecruitmentDetail(pageable);
    }
    @PostMapping()
    public ApiResponse<RecruitmentDetail> create(@RequestBody RecruitmentDetailDTO recruitmentDetailDTO) {
        return recruitmentDetailService.create(recruitmentDetailDTO);
    }
    @PutMapping()
    public ApiResponse<RecruitmentDetail> update(@RequestBody UpdateRecruitmentDetailDTO updateRecruitmentDetailDTO) {
        return recruitmentDetailService.update(updateRecruitmentDetailDTO.getRecruitmentDetailKeyDTO(), updateRecruitmentDetailDTO.getRecruitmentDetailDTO());
    }
}