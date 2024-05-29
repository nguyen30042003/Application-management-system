package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.AdvertisingFormDTO;
import com.example.projectcv.dto.request.AdvertisingFormKeyDTO;
import com.example.projectcv.dto.request.UpdateAdvertisingFormDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.AdvertisingForm;
import com.example.projectcv.entity.Enterprise;
import com.example.projectcv.entity.Member;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.entity.composite_key.AdvertisingFormKey;
import com.example.projectcv.repository.AdvertisingFormRepository;
import com.example.projectcv.services.AdvertisingFormService;
import com.example.projectcv.services.RecruitmentInformationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdvertisingFormServiceImpl implements AdvertisingFormService {
    private AdvertisingFormRepository advertisingFormRepository;
    private RecruitmentInformationService recruitmentInformationService;
    @Override
    public Page<AdvertisingForm> advertisingForms(Pageable pageable) {
        return null;
    }

    @Override
    public ApiResponse<AdvertisingForm> getById(AdvertisingFormKeyDTO advertisingFormKeyDTO) {
        AdvertisingFormKey key = new AdvertisingFormKey();
        key.setRecruitmentId(advertisingFormKeyDTO.getRecruitmentId());
        key.setRecruitmentTime(advertisingFormKeyDTO.getRecruitmentTime());
        ApiResponse<AdvertisingForm> apiResponse = new ApiResponse<>();
        Optional<AdvertisingForm> advertisingForm = advertisingFormRepository.findByRecruitmentIdAndRecruitmentTime(advertisingFormKeyDTO.getRecruitmentId(), advertisingFormKeyDTO.getRecruitmentTime());
        apiResponse.setData(advertisingForm.get());
        return apiResponse;
    }

    @Override
    public ApiResponse<AdvertisingForm> update(UpdateAdvertisingFormDTO updateAdvertisingFormDTO) {
        AdvertisingFormKeyDTO key = new AdvertisingFormKeyDTO();
        key.setRecruitmentId(updateAdvertisingFormDTO.getAdvertisingFormKeyDTO().getRecruitmentId());
        key.setRecruitmentTime(updateAdvertisingFormDTO.getAdvertisingFormKeyDTO().getRecruitmentTime());
        AdvertisingForm advertisingForm = getById(key).getData();
        advertisingForm.setType(updateAdvertisingFormDTO.getAdvertisingFormDTO().getType());
        ApiResponse<AdvertisingForm> apiResponse = new ApiResponse<>(advertisingFormRepository.saveAndFlush(advertisingForm));
        return apiResponse;
    }

    @Override
    public ApiResponse<AdvertisingForm> create(AdvertisingFormDTO advertisingFormDTO) {
        AdvertisingFormKey advertisingFormKey = new AdvertisingFormKey();
        advertisingFormKey.setRecruitmentId(advertisingFormDTO.getRecruitmentInformationID());
        advertisingFormKey.setRecruitmentTime(advertisingFormDTO.getRecruitmentTime());
        AdvertisingForm advertisingForm = new AdvertisingForm();
        advertisingForm.setType(advertisingFormDTO.getType());
        advertisingForm.setId(advertisingFormKey);

        RecruitmentInformation recruitmentInformation = recruitmentInformationService.getByID(advertisingFormDTO.getRecruitmentInformationID()).getData();
        advertisingForm.setRecruitmentInformation(recruitmentInformation);
        advertisingFormRepository.saveAndFlush(advertisingForm);
        ApiResponse<AdvertisingForm> apiResponse = new ApiResponse<>(advertisingForm);
        return apiResponse;
    }

    @Override
    public void delete(AdvertisingFormKeyDTO advertisingFormKeyDTO) {
        AdvertisingForm advertisingForm = getById(advertisingFormKeyDTO).getData();
        advertisingFormRepository.delete(advertisingForm);
    }

}
