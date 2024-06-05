package com.example.projectcv.dto.request;

import com.example.projectcv.entity.AdvertisingType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdvertisingFormDTO {
    @NotNull(message = "AdvertisingType cannot be null")
    private AdvertisingType type;

    private Timestamp date;

}
