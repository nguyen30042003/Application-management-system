package com.example.projectcv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "total_payment")
    private BigDecimal totalPayment;

    @Column(name = "is_full_payment")
    private boolean isFullPayment;

    @Column(name = "status")
    private String status;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_id", referencedColumnName = "id")
    private RecruitmentInformation recruitmentInformation;

    @OneToOne(mappedBy = "payment")
    private Invoice invoice;


    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private Set<PaymentDetail> paymentDetails;
}
