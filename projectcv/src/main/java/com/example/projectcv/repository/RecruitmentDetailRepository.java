package com.example.projectcv.repository;

import com.example.projectcv.entity.RecruitmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentDetailRepository extends JpaRepository<RecruitmentDetail, Long> {
    List<RecruitmentDetail> findByNomineeId(long nomineeId);


    List<RecruitmentDetail> findByRecruitmentInformationId(long recruitId);

    RecruitmentDetail findByNomineeIdAndRecruitmentInformationId(long nomineeId, long recruitId);
}
