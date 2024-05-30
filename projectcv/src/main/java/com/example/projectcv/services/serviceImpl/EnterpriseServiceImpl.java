package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.EnterpriseRequest;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Enterprise;
import com.example.projectcv.entity.Member;
import com.example.projectcv.entity.Role;
import com.example.projectcv.entity.UserAccount;
import com.example.projectcv.exception.AppException;
import com.example.projectcv.exception.ErrorCode;
import com.example.projectcv.repository.EnterpriseRepository;
import com.example.projectcv.repository.MemberRepository;
import com.example.projectcv.services.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Relation;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService {
    private EnterpriseRepository enterpriseRepository;
    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN')")
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

}
