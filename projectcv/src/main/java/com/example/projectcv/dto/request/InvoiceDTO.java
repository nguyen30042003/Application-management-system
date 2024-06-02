package com.example.projectcv.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@AllArgsConstructor
@Getter
@Setter
public class InvoiceDTO {
    @NotNull(message = "the time for sending invoices to enterprise not null")
    private Date dateOfSending;
}
