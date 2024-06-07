package com.example.projectcv.services;

import com.example.projectcv.dto.request.ReportDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.dto.response.report_response.ReportResponse;
import com.example.projectcv.entity.Report;

public interface ReportService {
    ApiResponse<Report> create();
    ReportResponse createReportDetail(long id, ReportDTO reportDTO);
}
