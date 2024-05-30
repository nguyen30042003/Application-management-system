package com.example.projectcv.controller;

import com.example.projectcv.dto.request.NomineeDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Nominee;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.services.RecruitmentInformationService;
import com.example.projectcv.services.serviceImpl.NomineeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/nominees")
public class NomineeController {
    private NomineeServiceImpl nomineeService;

    @GetMapping()
    public Page<Nominee> getAllNominee(Pageable pageable) {
        return nomineeService.getNominee(pageable);
    }
    @PostMapping()
    public ApiResponse<Nominee> create(@RequestBody NomineeDTO nomineeDTO) {
        return nomineeService.create(nomineeDTO);
    }
}
