package com.example.projectcv.services;

import com.example.projectcv.dto.request.PaymentDetailDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Payment;
import com.example.projectcv.entity.PaymentDetail;

public interface PaymentService {
    ApiResponse<PaymentDetail> createPayment(Long id, PaymentDetailDTO paymentDetailDTO);
}
