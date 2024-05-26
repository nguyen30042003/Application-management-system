package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.SignUpRequest;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Candidate;
import com.example.projectcv.entity.Role;
import com.example.projectcv.entity.UserAccount;
import com.example.projectcv.repository.AccountRepository;
import com.example.projectcv.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public ApiResponse<UserAccount> signup(SignUpRequest signUpRequest) {

       UserAccount userAccount = new UserAccount();
       userAccount.setRole(Role.CANDIDATE);
       userAccount.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

       Candidate candidate = new Candidate();
       candidate.setAddress(signUpRequest.getAddress());
       candidate.setEmail(signUpRequest.getEmail());
       candidate.setContact(signUpRequest.getContact());
       candidate.setUserAccount(userAccount);
        candidate.setName(signUpRequest.getName());

       userAccount.setMember(candidate);

       accountRepository.save(userAccount);

       ApiResponse<UserAccount> apiResponse =  new ApiResponse<UserAccount>() ;
       apiResponse.setData(userAccount);
        return apiResponse;
    }
}
