package com.example.projectcv.repository;

import com.example.projectcv.entity.ReportDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportDetailRepository extends JpaRepository<ReportDetail, Long> {
//    //@Query("SELECT rd FROM ReportDetail rd WHERE rd.id.reportId = :reportId AND rd.id.enterpriseId = :enterpriseId")
//    List<ReportDetail> findByReportIdAndEnterpriseId(long reportId, long enterpriseId);
//
//    // Custom query method to find ReportDetail entities by isPotential
//    List<ReportDetail> findByIsPotential(boolean isPotential);
//
//    // Custom query method to find ReportDetail entities by isGreatPotential
//    List<ReportDetail> findByIsGreatPotential(boolean isGreatPotential);
}
