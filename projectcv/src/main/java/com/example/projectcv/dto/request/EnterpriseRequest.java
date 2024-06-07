package com.example.projectcv.dto.request;

import com.example.projectcv.validator.EmailConstraint;
import com.example.projectcv.validator.PasswordConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Data
@AllArgsConstructor
@Setter
@Getter
public class EnterpriseRequest {
    @NotNull(message = "Name not null")
    private String name;
    @NotNull(message = "Address not null")
    private String address;
    @EmailConstraint(message = "INVALID_EMAIL")
    private String email;
    @NotNull(message = "Contract not null")
    private String contact;
    @NotNull(message = "Name company not null")
    private String companyName;
    @NotBlank(message = "Name company not null")
    private String taxCode;
    
    //@NotNull(message = "Date of expiration  not null")
    private Date dateOfExpiration;

    @PasswordConstraint(message = "Password must have more than 8 characters including numbers, capital letters and special characters")
    private String password;
}

