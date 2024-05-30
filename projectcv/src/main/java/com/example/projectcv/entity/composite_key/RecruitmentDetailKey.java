package com.example.projectcv.entity.composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentDetailKey {
    @Column(name = "recruit_id")
    Long recruitId;

    @Column(name = "nominee_id")
    Long nomineeId;

}
