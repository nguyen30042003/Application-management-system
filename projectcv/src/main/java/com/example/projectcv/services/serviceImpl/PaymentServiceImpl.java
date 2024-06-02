package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.PaymentDetailDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Payment;
import com.example.projectcv.entity.PaymentDetail;
import com.example.projectcv.entity.RecruitmentInformation;
import com.example.projectcv.repository.PaymentDetailRepository;
import com.example.projectcv.repository.PaymentRepository;
import com.example.projectcv.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private PaymentDetailRepository paymentDetailRepository;
    private PaymentRepository paymentRepository;
    @Override
    public ApiResponse<PaymentDetail> createPayment(Long id, PaymentDetailDTO paymentDetailDTO) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isEmpty())
        {
            throw new RuntimeException("Payment not found with id");
        }
        Set<PaymentDetail> paymentDetails = payment.get().getPaymentDetails();
        if(paymentDetails.size() == 0)
        {
            PaymentDetail paymentDetail = new PaymentDetail();
            paymentDetail.setAmount(paymentDetailDTO.getAmount());
            paymentDetail.setDate(new Date());
            paymentDetail.setPhase(1);
            paymentDetail.setType(paymentDetailDTO.getType());
            paymentDetail.setPayment(payment.get());
            paymentDetailRepository.save(paymentDetail);
            ApiResponse<PaymentDetail> apiResponse = new ApiResponse<>();
            apiResponse.setData(paymentDetail);
            return apiResponse;
        }
        else{
            PaymentDetail paymentDetail = new PaymentDetail();
            paymentDetail.setAmount(paymentDetailDTO.getAmount());
            paymentDetail.setDate(new Date());
            paymentDetail.setPhase(paymentDetails.size());
            paymentDetail.setType(paymentDetailDTO.getType());
            paymentDetail.setPayment(payment.get());
            paymentDetailRepository.save(paymentDetail);
            ApiResponse<PaymentDetail> apiResponse = new ApiResponse<>();
            apiResponse.setData(paymentDetail);
            return apiResponse;
        }
    }
}
