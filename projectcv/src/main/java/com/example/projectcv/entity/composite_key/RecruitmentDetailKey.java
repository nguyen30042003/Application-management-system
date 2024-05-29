package com.example.projectcv.entity.composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class RecruitmentDetailKey {
    @Column(name = "recruit_id")
    long recruitId;

    @Column(name = "nominee_id")
    long nomineeId;

}
