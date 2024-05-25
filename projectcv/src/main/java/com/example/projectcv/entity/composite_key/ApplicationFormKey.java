package com.example.projectcv.entity.composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ApplicationFormKey {

    private RecruitmentDetailKey recruitmentDetailKeyId;

    @Column(name = "candidate_id")
    private long candidateId;

}
