package com.example.projectcv.entity;

import com.example.projectcv.entity.composite_key.PaymentDetailKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "payment_detail")
public class PaymentDetail {


    @EmbeddedId
    PaymentDetailKey id = new PaymentDetailKey();

    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "type")
    private PaymentType type;
    @Column(name = "date")
    private Date date;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @MapsId("paymentId")
    @JoinColumn(name = "payment_id", referencedColumnName = "id",nullable = false)
    private Payment payment;
}
