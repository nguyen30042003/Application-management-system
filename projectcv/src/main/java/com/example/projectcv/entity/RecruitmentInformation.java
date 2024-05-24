package com.example.projectcv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "time")
    private Date time;

    @ManyToOne
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id")
    private Enterprise enterprise;

    @OneToMany(mappedBy = "recruitmentInformation", cascade = CascadeType.ALL)
    private Set<RecruitmentDetail> recruitmentDetails;

    @OneToOne(mappedBy = "recruitmentInformation")
    private AdvertisingForm advertisingForm;

}
