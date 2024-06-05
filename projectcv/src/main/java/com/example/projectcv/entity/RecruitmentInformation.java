package com.example.projectcv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "recruitment_information")
public class RecruitmentInformation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time")
    private int time;

    @ManyToOne(optional = false)
    @JoinColumn(name = "enterprise_id",nullable = false)
    private Enterprise enterprise;

    @JsonIgnore
    @OneToMany(mappedBy = "recruitmentInformation", cascade = CascadeType.ALL)
    private Set<RecruitmentDetail> recruitmentDetails;

    public void addRecruitmentDetail (RecruitmentDetail recruitmentDetail){
        recruitmentDetails.add(recruitmentDetail);
    }

    @JsonIgnore
    @OneToOne(mappedBy = "recruitmentInformation",optional = false,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private AdvertisingForm advertisingForm;

    @JsonIgnore
    @OneToOne(mappedBy = "recruitmentInformation",optional = false,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;

}
