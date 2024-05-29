package com.example.projectcv.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateAdvertisingFormDTO {
    private AdvertisingFormDTO advertisingFormDTO;
    private AdvertisingFormKeyDTO advertisingFormKeyDTO;
}
