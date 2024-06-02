package com.example.projectcv.dto.request;

import com.example.projectcv.entity.PaymentDetail;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
public class PaymentDTO {

    @DecimalMin(value = "0.0", inclusive = false, message = "Total money must be greater than 0")
    private BigDecimal totalMoney;
    @NotNull(message = "Full payment status cannot be null")
    boolean isFullPayment;
    @NotBlank(message = "Status cannot be null")
    @Size(min = 1, message = "Status must be between 1 and 50 characters")
    String status;

    Set<PaymentDetail> paymentDetailSet;

    InvoiceDTO invoiceDTO;
    
}
