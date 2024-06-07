package com.example.projectcv.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberDTO {
    @NotNull(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "Contact cannot be empty")
    private String contact;

    @NotNull(message = "Email cannot be empty")
    private String email;

    @NotNull(message = "Address cannot be empty")
    private String address;
}
