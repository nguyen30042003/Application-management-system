package com.example.projectcv.repository;

import com.example.projectcv.entity.Payment;
import com.example.projectcv.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long> {
}
