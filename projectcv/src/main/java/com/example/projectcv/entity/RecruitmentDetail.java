package com.example.projectcv.entity;

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
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "requestedInfo")
    private String requestedInfo;

    @ManyToOne
    @JoinColumn(name = "nomineeID", referencedColumnName = "id")
    private Nominee nominee;

    @ManyToOne
    @JoinColumn(name = "recruitID", referencedColumnName = "id")
    private RecruitmentInformation recruitmentInformation;

    @OneToMany(mappedBy = "recruitmentDetail")
    private Set<ApplicationForm> applicationForms;
}
