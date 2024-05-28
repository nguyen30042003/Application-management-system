package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.EnterpriseRequest;
import com.example.projectcv.entity.Enterprise;
import com.example.projectcv.exception.AppException;
import com.example.projectcv.exception.ErrorCode;
import com.example.projectcv.repository.EnterpriseRepository;
import com.example.projectcv.services.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService {
    private EnterpriseRepository enterpriseRepository;
    @Override
    public Enterprise create(EnterpriseRequest enterpriseRequest) {
        Enterprise enterprise = new Enterprise();
        if(enterpriseRepository.existsByCompanyName(enterpriseRequest.getCompanyName()))
        {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        enterprise.setName(enterpriseRequest.getName());
        enterprise.setAddress(enterpriseRequest.getAddress());
        enterprise.setEmail(enterpriseRequest.getEmail());
        enterprise.setContact(enterpriseRequest.getContact());
        enterprise.setCompanyName(enterpriseRequest.getCompanyName());
        enterprise.setTaxCode(enterpriseRequest.getTaxCode());
        enterprise.setDateOfExpiration(enterpriseRequest.getDateOfExpiration());
        return enterpriseRepository.saveAndFlush(enterprise);
    }
}
