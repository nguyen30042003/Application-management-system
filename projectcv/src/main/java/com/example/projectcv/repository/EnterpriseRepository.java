package com.example.projectcv.repository;

import com.example.projectcv.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    List<Enterprise> findByCompanyName(String companyName);

    Enterprise findByTaxCode(String taxCode);

    List<Enterprise> findByDateOfExpiration(Date dateOfExpiration);

    List<Enterprise> findByDateOfExpirationBefore(Date date);

    List<Enterprise> findByDateOfExpirationAfter(Date date);

    List<Enterprise> findByDateOfExpirationBetween(Date startDate, Date endDate);
}
