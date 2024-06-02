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
@Table(name = "report")
public class Report {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private Date date;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    private Set<ReportDetail> reportDetails;

    public void addReportDetails (ReportDetail reportDetail){
        reportDetails.add(reportDetail);
    }

}
