package com.example.projectcv.controller;

import com.example.projectcv.dto.request.ReportDTO;
import com.example.projectcv.dto.request.ReportDetailDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Report;
import com.example.projectcv.services.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    @PostMapping()
    public ApiResponse<Report> createReport() {
        return reportService.create();
    }
    @PostMapping("/{id}/reportDetail")
    public ApiResponse<Report> createReport( @PathVariable Long id, @RequestBody ReportDetailDTO reportDetailDTO) {
        return reportService.createReportDetail(id, reportDetailDTO);
    }
}
