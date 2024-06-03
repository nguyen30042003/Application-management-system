package com.example.projectcv.repository;

import com.example.projectcv.entity.RecruitmentInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;

public interface RecruitmentInformationRepository extends JpaRepository<RecruitmentInformation, Long> {
   // List<RecruitmentInformation> findByTimeBetween(Timestamp startTime, Timestamp endTime);



}
