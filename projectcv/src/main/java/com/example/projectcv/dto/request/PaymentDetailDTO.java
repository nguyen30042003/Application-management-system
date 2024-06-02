package com.example.projectcv.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@AllArgsConstructor
@Getter
@Setter
public class PaymentDetailDTO {

    @Min(value = 1, message = "Phase must be greater than or equal to 1")
    private int phase;

    @Positive(message = "Amount must be greater than 0")
    private double amount;

    @NotNull(message = "Type cannot be null")
    @Size(min = 1, message = "Type cannot be empty")
    private String type;

    @NotNull(message = "Date cannot be null")
    private Date date;
}
