package com.example.projectcv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "payment_detail")
public class PaymentDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "phase")
    private int phase;
    @Column(name = "amount")
    private double amount;
    @Column(name = "type")
    private String type;
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "paymentID", referencedColumnName = "id")
    private Payment payment;
}
