package com.example.projectcv.dto.response.recruitment_response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRespone {
    long id;
    BigDecimal totalPayment;
    String status;

}
