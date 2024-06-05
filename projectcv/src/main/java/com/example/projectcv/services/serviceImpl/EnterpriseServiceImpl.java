package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.EnterpriseRequest;
import com.example.projectcv.dto.request.RecruitmentDetailDTO;
import com.example.projectcv.dto.request.RecruitmentInformationDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.*;
import com.example.projectcv.entity.composite_key.AdvertisingFormKey;
import com.example.projectcv.exception.AppException;
import com.example.projectcv.exception.ErrorCode;
import com.example.projectcv.repository.*;
import com.example.projectcv.services.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import javax.management.relation.Relation;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService {
    private final PaymentRepository paymentRepository;
    private final RecruitmentInformationRepository recruitmentInformationRepository;
    private EnterpriseRepository enterpriseRepository;
    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;
    private NomineeRepository nomineeRepository;
    @Override
    public Enterprise create(EnterpriseRequest enterpriseRequest) {
        if(memberRepository.existsByEmail(enterpriseRequest.getEmail()))
        {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        UserAccount userAccount = new UserAccount();
        userAccount.setRole(Role.ENTERPRISE);
        userAccount.setPassword(passwordEncoder.encode(enterpriseRequest.getPassword()));
        Enterprise enterprise = getEnterprise(enterpriseRequest, userAccount);

        return enterpriseRepository.saveAndFlush(enterprise);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    private static Enterprise getEnterprise(EnterpriseRequest enterpriseRequest, UserAccount userAccount) {
        Enterprise enterprise = new Enterprise();

        enterprise.setName(enterpriseRequest.getName());
        enterprise.setAddress(enterpriseRequest.getAddress());
        enterprise.setEmail(enterpriseRequest.getEmail());
        enterprise.setContact(enterpriseRequest.getContact());
        enterprise.setCompanyName(enterpriseRequest.getCompanyName());
        enterprise.setTaxCode(enterpriseRequest.getTaxCode());
        enterprise.setDateOfExpiration(enterpriseRequest.getDateOfExpiration());
        enterprise.setUserAccount(userAccount);
        userAccount.setMember(enterprise);
        return enterprise;
    }

    @Override
    public ApiResponse<Enterprise> getById(Long id) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
        if(enterprise.isPresent()) {
            ApiResponse<Enterprise> apiResponse = new ApiResponse<>();
            apiResponse.setData(enterprise.get());
            return apiResponse;
        } else {
            throw new RuntimeException("Enterprise not found");
        }
    }


    @PreAuthorize("hasAuthority('ENTERPRISE')")
    @Override
    public ApiResponse<RecruitmentInformation> createRecruitment(Long id, RecruitmentInformationDTO recruitmentCreationDTO) {

        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
        if(enterprise.isEmpty()) {
            throw new AppException(ErrorCode.ENTERPRISE_NOT_EXISTED);

        }
        Enterprise newEnterprise = enterprise.get();

        RecruitmentInformation recruitmentInformation = new RecruitmentInformation();
        recruitmentInformation.setTime(recruitmentCreationDTO.getTime());
        recruitmentInformation.setEnterprise(newEnterprise);

        Payment payment = new Payment();
        payment.setFullPayment(recruitmentCreationDTO.getPayment().isFullPayment());
        payment.setStatus("done");


        for (RecruitmentDetailDTO recruitmentDetailDTO: recruitmentCreationDTO.getNominees()){
            RecruitmentDetail recruitmentDetail = new RecruitmentDetail();
            recruitmentDetail.setQuantity(recruitmentDetailDTO.getQuantity());

            Optional<Nominee> nominee = nomineeRepository.findById(recruitmentDetailDTO.getNomineeId());
            if(nominee.isEmpty()) {
                throw new AppException(ErrorCode.NOMINEE_NOT_EXISTED);

            }
            Nominee newNominee = nominee.get();
            recruitmentDetail.setNominee(newNominee);
           if ( newNominee.getRecruitmentDetails() == null ) {
                newNominee.setRecruitmentDetails(new HashSet<>());
           }
           newNominee.getRecruitmentDetails().add(recruitmentDetail);

            recruitmentDetail.setRecruitmentInformation(recruitmentInformation);
            if(recruitmentInformation.getRecruitmentDetails() == null)
                recruitmentInformation.setRecruitmentDetails(new HashSet<>());

            recruitmentInformation.addRecruitmentDetail(recruitmentDetail);

            recruitmentDetail.setRequestedInfo(recruitmentDetailDTO.getRequestedInfo());
        }
        recruitmentInformation.setPayment(payment);
        AdvertisingForm advertisingForm = new AdvertisingForm();
        advertisingForm.setType(Enum.valueOf(Type.class, recruitmentCreationDTO.getAdvertisingType()));
        recruitmentInformation.setAdvertisingForm(advertisingForm);
       // payment.setRecruitmentInformation(recruitmentInformation);


        recruitmentInformationRepository.save(recruitmentInformation);;
        ApiResponse<RecruitmentInformation> apiResponse = new ApiResponse<>();
        apiResponse.setData(recruitmentInformation);
        return apiResponse;
    }

}
