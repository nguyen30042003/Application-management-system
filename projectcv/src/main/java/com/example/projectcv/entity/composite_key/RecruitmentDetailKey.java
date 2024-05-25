package com.example.projectcv.entity.composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RecruitmentDetailKey {
    @Column(name = "recruit_id")
    long recruitId;

    @Column(name = "nominee_id")
    long nomineeId;

}
