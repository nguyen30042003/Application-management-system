package com.example.projectcv.repository;

import com.example.projectcv.entity.AdvertisingForm;
import com.example.projectcv.entity.composite_key.AdvertisingFormKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Optional;

public interface AdvertisingFormRepository extends JpaRepository<AdvertisingForm, Long> {
    //AdvertisingForm findByRecruitmentIdAndRecruitmentTime(long recruitmentId, Timestamp recruitmentTime);

    @Query("SELECT a FROM AdvertisingForm a WHERE a.id.recruitmentId = :recruitmentId AND a.id.recruitmentTime = :recruitmentTime")
    Optional<AdvertisingForm> findByRecruitmentIdAndRecruitmentTime(@Param("recruitmentId") long recruitmentId,
                                                                    @Param("recruitmentTime") Timestamp recruitmentTime);
}
