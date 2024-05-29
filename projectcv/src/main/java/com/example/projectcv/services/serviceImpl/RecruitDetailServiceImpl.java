package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.RecruitmentDetailDTO;
import com.example.projectcv.dto.request.RecruitmentDetailKeyDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.AdvertisingForm;
import com.example.projectcv.entity.Nominee;
import com.example.projectcv.entity.RecruitmentDetail;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.entity.composite_key.AdvertisingFormKey;
import com.example.projectcv.entity.composite_key.RecruitmentDetailKey;
import com.example.projectcv.repository.RecruitmentDetailRepository;
import com.example.projectcv.services.NomineeService;
import com.example.projectcv.services.RecruitmentDetailService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RecruitDetailServiceImpl implements RecruitmentDetailService {
    private RecruitmentDetailRepository recruitmentDetailRepository;
    private NomineeServiceImpl nomineeService;
    private RecruitmentInformationServiceImpl recruitmentInformationService;
    @Override
    public Page<RecruitmentDetail> getRecruitmentDetail(Pageable pageable) {
        return recruitmentDetailRepository.findAll(pageable);
    }

    @Override
    public ApiResponse<RecruitmentDetail> getByID(RecruitmentDetailKeyDTO recruitmentDetailKeyDTO   ) {
        RecruitmentDetailKey key = new RecruitmentDetailKey();
        key.setNomineeId(recruitmentDetailKeyDTO.getNomineeId());
        key.setRecruitId(recruitmentDetailKeyDTO.getRecruitId());
        Optional<RecruitmentDetail> recruitmentDetail = recruitmentDetailRepository.findByRecruitIdAndNomineeId(recruitmentDetailKeyDTO.getRecruitId(), recruitmentDetailKeyDTO.getNomineeId());
        ApiResponse<RecruitmentDetail> apiResponse = new ApiResponse<>();
        apiResponse.setData(recruitmentDetail.get());
        return apiResponse;
    }

    @Override
    public ApiResponse<RecruitmentDetail> update(RecruitmentDetailKeyDTO recruitmentDetailKeyDTO , RecruitmentDetailDTO recruitmentDetailDTO) {
        RecruitmentDetail recruitmentDetail = getByID(recruitmentDetailKeyDTO).getData();
        recruitmentDetail.setQuantity(recruitmentDetailDTO.getQuantity());
        recruitmentDetail.setRequestedInfo(recruitmentDetailDTO.getRequestedInfo());
        Nominee nominee = nomineeService.getByID(recruitmentDetailDTO.getNomineeID()).getData();
        RecruitmentInformation recruitmentInformation = recruitmentInformationService.getByID(recruitmentDetailDTO.getRecruitmentInformationID()).getData();
        recruitmentDetail.setRecruitmentInformation(recruitmentInformation);
        recruitmentDetail.setNominee(nominee);
        return new ApiResponse<>(recruitmentDetailRepository.saveAndFlush(recruitmentDetail));
    }

    @Override
    public ApiResponse<RecruitmentDetail> create(RecruitmentDetailDTO recruitmentDetailDTO) {
        RecruitmentDetailKey recruitmentDetailKey = new RecruitmentDetailKey();
        recruitmentDetailKey.setRecruitId(recruitmentDetailDTO.getRecruitmentInformationID());
        recruitmentDetailKey.setNomineeId(recruitmentDetailKey.getNomineeId());
        Nominee nominee = nomineeService.getByID(recruitmentDetailDTO.getNomineeID()).getData();
        RecruitmentInformation recruitmentInformation = recruitmentInformationService.getByID(recruitmentDetailDTO.getRecruitmentInformationID()).getData();
        RecruitmentDetail recruitmentDetail = new RecruitmentDetail();
        recruitmentDetail.setRecruitmentInformation(recruitmentInformation);
        recruitmentDetail.setNominee(nominee);
        recruitmentDetail.setQuantity(recruitmentDetailDTO.getQuantity());
        recruitmentDetail.setRequestedInfo(recruitmentDetailDTO.getRequestedInfo());
        recruitmentDetail.setId(recruitmentDetailKey);
        return new ApiResponse<>(recruitmentDetailRepository.saveAndFlush(recruitmentDetail));
    }

    @Override
    public void delete(RecruitmentDetailKeyDTO recruitmentDetailKeyDTO) {
        RecruitmentDetail recruitmentDetail = getByID(recruitmentDetailKeyDTO).getData();
        recruitmentDetailRepository.delete(recruitmentDetail);
    }
}
