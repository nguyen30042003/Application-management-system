package com.example.projectcv.dto.request;

import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.entity.Type;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdvertisingFormDTO {
    @NotNull(message = "Type cannot be null")
    private Type type;


}
