package com.example.projectcv.repository;

import com.example.projectcv.entity.PaymentDetail;
import com.example.projectcv.entity.RecruitmentDetail;
import com.example.projectcv.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
  //  List<RecruitmentDetail> findByDateBetween(Date startDate, Date endDate);
}
