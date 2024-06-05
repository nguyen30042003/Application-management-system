package com.example.projectcv.entity.composite_key;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PaymentDetailKey {
    private long paymentId;
    private int phase ;
}
