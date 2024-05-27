package com.example.projectcv.repository;

import com.example.projectcv.entity.RecruitmentInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface RecruitmentInformationRepository extends JpaRepository<RecruitmentInformation, Long> {
    List<RecruitmentInformation> findByTimeBetween(Timestamp startTime, Timestamp endTime);
}
