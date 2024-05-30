package com.example.projectcv.entity;

import com.example.projectcv.entity.composite_key.RecruitmentDetailKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "recruitment_detail")
public class RecruitmentDetail {

    @EmbeddedId
    RecruitmentDetailKey id ;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "requested_info")
    private String requestedInfo;

    @ManyToOne(optional = false)
    @MapsId("nomineeId")
    @JoinColumn(name = "nominee_id",nullable = false)
    private Nominee nominee;


    @ManyToOne
    @MapsId("recruitId")
    @JoinColumn(name = "recruit_id")
    private RecruitmentInformation recruitmentInformation;

    @OneToMany(mappedBy = "recruitmentDetail")
    private Set<ApplicationForm> applicationForms;

}
