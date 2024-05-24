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
@Table(name = "application_form")
public class ApplicationForm {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "memberID", referencedColumnName = "id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "recruitID", referencedColumnName = "id")
    private RecruitmentDetail recruitmentDetail;

    @Column(name = "is_processed")
    private boolean isProcessed;
    @Column(name = "is_responded")
    private boolean isResponded;
}
