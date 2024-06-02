package com.example.projectcv.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor // Thêm constructor không tham số
@Getter
@Setter
public class ReportDTO {
    private Set<ReportDetailDTO> reportDetailDTOSet;
}
