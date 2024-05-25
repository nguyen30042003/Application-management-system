package com.example.projectcv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private long totalPayment;

    @Column(name = "is_full_payment")
    private boolean isFullPayment;

    @Column(name = "status")
    private String status;

    @OneToOne(optional = false)
    @JoinColumn(name = "recruitID", referencedColumnName = "id",nullable = false)
    private RecruitmentInformation recruitmentInformation;

    @OneToOne(mappedBy = "payment",optional = false)
    private Invoice invoice;


    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private Set<PaymentDetail> paymentDetails;
}
