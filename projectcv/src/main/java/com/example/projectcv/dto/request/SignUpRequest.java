package com.example.projectcv.dto.request;

import com.example.projectcv.entity.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpRequest {

    private String email;
    private String password;
    private String name;
    private String address;
    private String contact;
}
