package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.EnterpriseRequest;
import com.example.projectcv.dto.request.RecruitmentDetailDTO;
import com.example.projectcv.dto.request.RecruitmentInformationDTO;
import com.example.projectcv.dto.response.recruitment_response.EnterpriseResponse;
import com.example.projectcv.dto.response.nominee_response.NomineeResponse;
import com.example.projectcv.dto.response.recruitment_response.PaymentRespone;
import com.example.projectcv.dto.response.recruitment_response.RecruitmentsResponse;
import com.example.projectcv.entity.*;
import com.example.projectcv.exception.AppException;
import com.example.projectcv.exception.ErrorCode;
import com.example.projectcv.repository.*;
import com.example.projectcv.services.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;


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
    public EnterpriseResponse create(EnterpriseRequest enterpriseRequest) {
        if(memberRepository.existsByEmail(enterpriseRequest.getEmail()))
        {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        UserAccount userAccount = new UserAccount();
        userAccount.setRole(Role.ENTERPRISE);
        userAccount.setPassword(passwordEncoder.encode(enterpriseRequest.getPassword()));
        Enterprise enterprise = getEnterprise(enterpriseRequest, userAccount);
        Enterprise newEnterprise = enterpriseRepository.save(enterprise);

        EnterpriseResponse enterpriseResponse = new EnterpriseResponse();
        enterpriseResponse.setEnterPriseId(newEnterprise.getId());
        enterpriseResponse.setEnterPriseName(newEnterprise.getName());
        enterpriseResponse.setContact(newEnterprise.getContact());
        enterpriseResponse.setEnterPriseEmail(newEnterprise.getEmail());
        enterpriseResponse.setEnterPriseAddress(newEnterprise.getAddress());
        enterpriseResponse.setContact(newEnterprise.getContact());
        enterpriseResponse.setTax(newEnterprise.getTaxCode());
        enterpriseResponse.setDateOfExpiration(newEnterprise.getDateOfExpiration());

        return enterpriseResponse;
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
    public EnterpriseResponse getById(Long id) {
        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
        if(enterprise.isPresent()) {
            Enterprise newEnterprise = enterprise.get();

            EnterpriseResponse enterpriseResponse = new EnterpriseResponse();
            enterpriseResponse.setEnterPriseId(newEnterprise.getId());
            enterpriseResponse.setEnterPriseName(newEnterprise.getName());
            enterpriseResponse.setContact(newEnterprise.getContact());
            enterpriseResponse.setEnterPriseEmail(newEnterprise.getEmail());
            enterpriseResponse.setEnterPriseAddress(newEnterprise.getAddress());
            enterpriseResponse.setContact(newEnterprise.getContact());
            enterpriseResponse.setTax(newEnterprise.getTaxCode());
            enterpriseResponse.setDateOfExpiration(newEnterprise.getDateOfExpiration());

            return enterpriseResponse;
        } else {
            throw new AppException(ErrorCode.ENTERPRISE_NOT_EXISTED);
        }
    }


    @PreAuthorize("hasAuthority('ENTERPRISE')")
    @Override
    public RecruitmentsResponse createRecruitment(Long id, RecruitmentInformationDTO recruitmentCreationDTO) {

        Optional<Enterprise> enterprise = enterpriseRepository.findById(id);
        if(enterprise.isEmpty()) {
            throw new AppException(ErrorCode.ENTERPRISE_NOT_EXISTED);
        }
        Enterprise newEnterprise = enterprise.get();

        RecruitmentInformation recruitmentInformation = new RecruitmentInformation();
        recruitmentInformation.setTime(recruitmentCreationDTO.getTime());
        recruitmentInformation.setEnterprise(newEnterprise);

        Payment payment = new Payment();

        payment.setTotalPayment(new BigDecimal(200000));

        payment.setFullPayment(recruitmentCreationDTO.isFullPayment());
        if (payment.isFullPayment()) {
            payment.setStatus("done");
            if(!Objects.equals(recruitmentCreationDTO.getAmount(), payment.getTotalPayment())) {
             throw new RuntimeException("Amount is not valid");
            }
        }
        else payment.setStatus("not done");

        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.getId().setPhase(1);
        paymentDetail.setAmount(recruitmentCreationDTO.getAmount());
        paymentDetail.setType(PaymentType.valueOf(recruitmentCreationDTO.getTypePayment()));
        paymentDetail.setDate(new Date());
        paymentDetail.setPayment(payment);
        if(payment.getPaymentDetails() == null) {
            payment.setPaymentDetails(new HashSet<>());
        }
        payment.getPaymentDetails().add(paymentDetail);
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
        advertisingForm.setType(Enum.valueOf(AdvertisingType.class, recruitmentCreationDTO.getAdvertisingType()));
        recruitmentInformation.setAdvertisingForm(advertisingForm);
       // payment.setRecruitmentInformation(recruitmentInformation);
        advertisingForm.setRecruitmentInformation(recruitmentInformation);
        RecruitmentInformation newRecruitmentInformation = recruitmentInformationRepository.save(recruitmentInformation);


        RecruitmentsResponse recruitmentsResponse = new RecruitmentsResponse();

        EnterpriseResponse enterpriseResponse = new EnterpriseResponse();
        enterpriseResponse.setEnterPriseId(newEnterprise.getId());
        enterpriseResponse.setEnterPriseName(newEnterprise.getName());
        enterpriseResponse.setContact(newEnterprise.getContact());
        enterpriseResponse.setEnterPriseEmail(newEnterprise.getEmail());
        enterpriseResponse.setEnterPriseAddress(newEnterprise.getAddress());
        enterpriseResponse.setContact(newEnterprise.getContact());
        enterpriseResponse.setTax(newEnterprise.getTaxCode());
        enterpriseResponse.setDateOfExpiration(newEnterprise.getDateOfExpiration());
        recruitmentsResponse.setEnterprise(enterpriseResponse);

        PaymentRespone paymentRespone = new PaymentRespone();
        paymentRespone.setId(newRecruitmentInformation.getPayment().getId());
        paymentRespone.setTotalPayment(newRecruitmentInformation.getPayment().getTotalPayment());
        paymentRespone.setStatus(newRecruitmentInformation.getPayment().getStatus());
        recruitmentsResponse.setPaymentRespone(paymentRespone);

        List<NomineeResponse> nomineeResponseSet = new ArrayList<>();
        for(RecruitmentDetail recruitmentDetail : recruitmentInformation.getRecruitmentDetails())
        {
            NomineeResponse nomineeResponse = new NomineeResponse();
            nomineeResponse.setNomineeId(recruitmentDetail.getNominee().getId());
            nomineeResponse.setNomineeName(recruitmentDetail.getNominee().getName());
            nomineeResponse.setQuantity(recruitmentDetail.getQuantity());
            nomineeResponse.setRequestInfo(recruitmentDetail.getRequestedInfo());
            nomineeResponseSet.add(nomineeResponse);
        }
        recruitmentsResponse.setNominees(nomineeResponseSet);

        recruitmentsResponse.setId(newRecruitmentInformation.getId());
        recruitmentsResponse.setTime(newRecruitmentInformation.getTime());


        return recruitmentsResponse;
    }

}
