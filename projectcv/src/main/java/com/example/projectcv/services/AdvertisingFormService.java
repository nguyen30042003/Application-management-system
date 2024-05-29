package com.example.projectcv.services;

import com.example.projectcv.dto.request.AdvertisingFormDTO;
import com.example.projectcv.dto.request.AdvertisingFormKeyDTO;
import com.example.projectcv.dto.request.UpdateAdvertisingFormDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.AdvertisingForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.List;

public interface AdvertisingFormService {
    Page<AdvertisingForm> advertisingForms(Pageable pageable);
    ApiResponse<AdvertisingForm> getById(AdvertisingFormKeyDTO advertisingFormKeyDTO);
    ApiResponse<AdvertisingForm> update(UpdateAdvertisingFormDTO updateAdvertisingFormDTO);
    ApiResponse<AdvertisingForm> create(AdvertisingFormDTO advertisingFormDTO);
    void delete(AdvertisingFormKeyDTO advertisingFormKeyDTO);
}
