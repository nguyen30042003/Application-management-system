package com.example.projectcv.dto.request;

import com.example.projectcv.entity.UserAccount;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class SignUpRequest {

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Size(min = 1, message = "Password must be at least 8 characters")
    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Address is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @Size(min = 10, max = 10, message = "The phone number must contain 10 digits")
    @NotBlank(message = "Contact is mandatory")
    private String contact;
}
