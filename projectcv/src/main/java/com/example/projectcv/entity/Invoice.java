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
@Table(name = "invoice")
public class Invoice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date_of_sending")
    private Date dateOfSending;

    @OneToOne(optional = false)
    @JoinColumn(name = "paymentID", referencedColumnName = "id",nullable = false)
    private Payment payment;
}
