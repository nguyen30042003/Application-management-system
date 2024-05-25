package com.example.projectcv.entity;

import com.example.projectcv.entity.composite_key.ReportDetailKey;
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

    @EmbeddedId
    private ReportDetailKey id;

    @Column(name = "is_potential")
    private boolean isPotential;
    @Column(name = "is_great_potential")
    private boolean isGreatPotential;
    @Column(name = "strategy")
    private String strategy;

    @ManyToOne(optional = false)
    @MapsId("reportId")
    @JoinColumn(name = "report_id", referencedColumnName = "id", nullable = false)
    private Report report;

    @ManyToOne(optional = false)
    @MapsId("enterpriseId")
    @JoinColumn(name = "enterprise_id", referencedColumnName = "id",nullable = false)
    private Enterprise enterprise;
}
