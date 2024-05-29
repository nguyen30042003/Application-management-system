package com.example.projectcv.repository;

import com.example.projectcv.entity.AdvertisingForm;
import com.example.projectcv.entity.RecruitmentDetail;
import com.example.projectcv.entity.composite_key.AdvertisingFormKey;
import com.example.projectcv.entity.composite_key.RecruitmentDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface RecruitmentDetailRepository extends JpaRepository<RecruitmentDetail, Long> {
    @Query("SELECT r FROM RecruitmentDetail r WHERE r.id.recruitId = :recruitId AND r.id.nomineeId = :nomineeId")
    Optional<RecruitmentDetail> findByRecruitIdAndNomineeId(@Param("recruitId") long recruitId,
                                                            @Param("nomineeId") long nomineeId);
    //RecruitmentDetail findByRecruitmentDetailKey(RecruitmentDetailKey recruitmentDetailKey);
//    List<RecruitmentDetail> findByNomineeId(long nomineeId);
//
//
//    List<RecruitmentDetail> findByRecruitmentInformationId(long recruitId);
//
//    RecruitmentDetail findByNomineeIdAndRecruitmentInformationId(long nomineeId, long recruitId);
}
