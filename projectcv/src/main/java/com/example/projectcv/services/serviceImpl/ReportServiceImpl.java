package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.ReportDetailDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Enterprise;
import com.example.projectcv.entity.Report;
import com.example.projectcv.entity.ReportDetail;
import com.example.projectcv.entity.composite_key.ReportDetailKey;
import com.example.projectcv.repository.EnterpriseRepository;
import com.example.projectcv.repository.ReportDetailRepository;
import com.example.projectcv.repository.ReportRepository;
import com.example.projectcv.services.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final EnterpriseRepository enterpriseRepository;
    private final ReportRepository reportRepository;
    private final ReportDetailRepository reportDetailRepository;

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ApiResponse<Report> createReportDetail(long id, ReportDetailDTO reportDetailDTO) {
        Optional<Report> report = reportRepository.findById(id);
        if (report.isEmpty()) {
            throw new RuntimeException("Report is not found");
        }
        if(report.get().getReportDetails() == null)
        {
            report.get().setReportDetails(new HashSet<>());
        }

        Optional<Enterprise> enterprise = enterpriseRepository.findById(reportDetailDTO.getEnterpriseId());
        if (enterprise.isEmpty()) {
            throw new RuntimeException("Enterprise is not found");
        }
        ReportDetailKey reportDetailKey = new ReportDetailKey(report.get().getId(), enterprise.get().getId());

        ReportDetail reportDetail = new ReportDetail();
        reportDetail.setId(reportDetailKey);
        reportDetail.setStrategy(reportDetailDTO.getStrategy());
        reportDetail.setPotential(reportDetailDTO.isPotential());
        reportDetail.setGreatPotential(reportDetailDTO.isGreatPotential());
        Enterprise enterprise1 = enterprise.get();
        reportDetail.setEnterprise(enterprise1);
        reportDetail.setReport(report.get());
        report.get().addReportDetails(reportDetail);
        //reportDetailRepository.save(reportDetail);
        reportRepository.saveAndFlush(report.get());
        ApiResponse<Report> apiResponse = new ApiResponse<>();
        apiResponse.setData(report.get());
        return apiResponse;
    }

    @Override
    public ApiResponse<Report> create() {
       Report report = new Report();
       report.setDate(new Date());
       reportRepository.save(report);
       return new ApiResponse<>(report);
    }


}
