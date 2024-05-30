package com.example.projectcv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "enterprise")
public class Enterprise extends Member{

    @Column(name = "company_name")
    private String companyName;
    @Column(name = "tax_code")
    private String taxCode;
    @Column(name = "date_of_expiration")
    private Date dateOfExpiration;

    @JsonIgnore
    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
    private Set<RecruitmentInformation> recruitmentInformations;

    @OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
    private Set<ReportDetail> reportDetails;


}
