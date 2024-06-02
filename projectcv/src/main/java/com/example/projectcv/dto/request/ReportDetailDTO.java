package com.example.projectcv.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor // Thêm constructor không tham số
@Getter
@Setter
public class ReportDetailDTO {
    private boolean isPotential;
    private boolean isGreatPotential;
    private String strategy;
    private long enterpriseId;
}
