package com.example.projectcv.services;

import com.example.projectcv.dto.request.ReportDTO;
import com.example.projectcv.dto.request.ReportDetailDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.dto.response.recruitment_response.ReportRespone;
import com.example.projectcv.entity.Report;

public interface ReportService {
    ApiResponse<Report> create();
    ReportRespone createReportDetail(long id, ReportDTO reportDTO);
}
