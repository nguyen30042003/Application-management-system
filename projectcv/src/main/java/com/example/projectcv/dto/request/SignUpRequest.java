package com.example.projectcv.dto.request;

import com.example.projectcv.Validator.EmailConstraint;
import com.example.projectcv.Validator.PasswordConstraint;
import com.example.projectcv.entity.UserAccount;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class SignUpRequest {


    @EmailConstraint(message = "INVALID_EMAIL")
    private String email;

    @PasswordConstraint(message = "Password must have more than 8 characters including numbers, capital letters and special characters")
    private String password;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @Size(min = 10, max = 10, message = "The phone number must contain 10 digits")
    @NotBlank(message = "Contact is mandatory")
    private String contact;
}
