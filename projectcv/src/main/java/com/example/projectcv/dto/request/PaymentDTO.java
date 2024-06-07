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


    @NotNull(message = "Full payment status cannot be null")
    boolean isFullPayment;

    @NotNull(message = "Payment type cannot be null")
    String type;

    InvoiceDTO invoiceDTO;
    
}
