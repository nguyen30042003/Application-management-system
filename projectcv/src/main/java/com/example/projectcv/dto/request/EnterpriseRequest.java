package com.example.projectcv.dto.request;

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
    private String name;
    private String address;
    private String email;
    private String contact;
    private String companyName;
    private String taxCode;
    private Date dateOfExpiration;

}
