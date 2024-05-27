package com.example.projectcv.repository;

import com.example.projectcv.entity.Payment;
import com.example.projectcv.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long> {
    List<PaymentDetail> findByAmountBetween(double minAmount, double maxAmount);

    List<PaymentDetail> findByDateBetween(Date startDate, Date endDate);
}
