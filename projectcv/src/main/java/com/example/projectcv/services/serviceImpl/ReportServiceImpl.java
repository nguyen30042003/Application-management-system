package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.ReportDTO;
import com.example.projectcv.dto.request.ReportDetailDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.dto.response.recruitment_response.EnterpriseResponse;
import com.example.projectcv.dto.response.recruitment_response.ReportDetailRespone;
import com.example.projectcv.dto.response.recruitment_response.ReportRespone;
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

import java.util.*;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final EnterpriseRepository enterpriseRepository;
    private final ReportRepository reportRepository;
    private final ReportDetailRepository reportDetailRepository;


    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ReportRespone createReportDetail(long id, ReportDTO reportDTO) {
        Optional<Report> reportCheck = reportRepository.findById(id);
        if (reportCheck.isEmpty()) {
            throw new RuntimeException("Report is not found");
        }
        Report report = reportCheck.get();
        Set<ReportDetail> reportDetails  = new HashSet<>();
        for(ReportDetailDTO reportDetailDTO : reportDTO.getReportDetailDTOSet())
        {
            Optional<Enterprise> enterprise = enterpriseRepository.findById(reportDetailDTO.getEnterpriseId());
            if (enterprise.isEmpty()) {
                throw new RuntimeException("Enterprise is not found");
            }
            ReportDetail reportDetail = new ReportDetail();
            ReportDetailKey reportDetailKey = new ReportDetailKey(report.getId(), enterprise.get().getId());
            reportDetail.setId(reportDetailKey);
            reportDetail.setEnterprise(enterprise.get());
            reportDetail.setReport(report);
            System.out.println(reportDetailDTO.isPotential());
            reportDetail.setStrategy(reportDetailDTO.getStrategy());
            reportDetail.setPotential(reportDetailDTO.isPotential());
            reportDetail.setGreatPotential(reportDetailDTO.isGreatPotential());
            reportDetails.add(reportDetail);
        }
        report.setReportDetails(reportDetails);
        report.setDate(new Date());

        Report newReport = reportRepository.save(report);

        ReportRespone reportRespone = new ReportRespone();
        List<ReportDetailRespone> reportDetailResponeList = new ArrayList<>();
        for(ReportDetail reportDetail : newReport.getReportDetails())
        {
            ReportDetailRespone reportDetailRespone = new ReportDetailRespone();
            reportDetailRespone.set_potential(reportDetail.isPotential());
            reportDetailRespone.set_greate_potential(reportDetailRespone.is_greate_potential());
            reportDetailRespone.setStrategy(reportDetail.getStrategy());

            EnterpriseResponse enterpriseResponse = new EnterpriseResponse();
            enterpriseResponse.setEnterPriseId(reportDetail.getEnterprise().getId());
            enterpriseResponse.setEnterPriseName(reportDetail.getEnterprise().getName());
            enterpriseResponse.setContact(reportDetail.getEnterprise().getContact());
            enterpriseResponse.setEnterPriseEmail(reportDetail.getEnterprise().getEmail());
            enterpriseResponse.setEnterPriseAddress(reportDetail.getEnterprise().getAddress());
            enterpriseResponse.setContact(reportDetail.getEnterprise().getContact());
            enterpriseResponse.setTax(reportDetail.getEnterprise().getTaxCode());
            enterpriseResponse.setDateOfExpiration(reportDetail.getEnterprise().getDateOfExpiration());
            reportDetailRespone.setEnterpriseResponse(enterpriseResponse);

            reportDetailResponeList.add(reportDetailRespone);
        }

        reportRespone.setReportDetailResponeList(reportDetailResponeList);
        reportRespone.setId(newReport.getId());
        reportRespone.setDate(newReport.getDate());

        return reportRespone;
//        if(report.get().getReportDetails() == null)
//        {
//            report.get().setReportDetails(new HashSet<>());
//        }
//
//        Optional<Enterprise> enterprise = enterpriseRepository.findById(reportDetailDTO.getEnterpriseId());
//        if (enterprise.isEmpty()) {
//            throw new RuntimeException("Enterprise is not found");
//        }
//        ReportDetailKey reportDetailKey = new ReportDetailKey(report.get().getId(), enterprise.get().getId());
//
//        ReportDetail reportDetail = new ReportDetail();
//        reportDetail.setId(reportDetailKey);
//        reportDetail.setStrategy(reportDetailDTO.getStrategy());
//        reportDetail.setPotential(reportDetailDTO.isPotential());
//        reportDetail.setGreatPotential(reportDetailDTO.isGreatPotential());
//        Enterprise enterprise1 = enterprise.get();
//        reportDetail.setEnterprise(enterprise1);
//        reportDetail.setReport(report.get());
//        report.get().addReportDetails(reportDetail);
//        //reportDetailRepository.save(reportDetail);
//        reportRepository.saveAndFlush(report.get());
//        ApiResponse<Report> apiResponse = new ApiResponse<>();
//        apiResponse.setData(report.get());
//        return apiResponse;
    }

    @Override
    public ApiResponse<Report> create() {
       Report report = new Report();
       report.setDate(new Date());
       reportRepository.save(report);
       return new ApiResponse<>(report);
    }


}
