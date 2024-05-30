package com.example.projectcv.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PaymentDTO {
    private BigDecimal totalMoney;
    boolean isFullPayment;
    String status;
    
}
