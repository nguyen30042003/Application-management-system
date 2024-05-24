package com.example.projectcv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "report_detail")
public class ReportDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "is_potential")
    private boolean isPotential;
    @Column(name = "is_great_potential")
    private boolean isGreatPotential;
    @Column(name = "strategy")
    private String Strategy;

    @ManyToOne
    @JoinColumn(name = "reportID", referencedColumnName = "id")
    private Report report;
    @ManyToOne
    @JoinColumn(name = "enterpriseID", referencedColumnName = "id")
    private Enterprise enterprise;
}
