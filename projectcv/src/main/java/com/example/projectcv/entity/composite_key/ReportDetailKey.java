package com.example.projectcv.entity.composite_key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ReportDetailKey {
    @Column(name = "report_id")
    private long reportId;

    @Column(name = "enterprise_id")
    private long enterpriseId;
}
