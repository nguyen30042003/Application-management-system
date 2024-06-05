package com.example.projectcv.dto.request;

import com.example.projectcv.entity.Nominee;
import com.example.projectcv.entity.RecruitmentInformation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class RecruitmentDetailDTO {
    @Positive(message = "Quantity must be a positive number")
    private int quantity;
    @NotBlank(message = "Requested info cannot be blank")
    private String requestedInfo;

    @NotNull(message = "Nominee ID cannot be null")
    private Long nomineeId;
}
