package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.SignInRequest;
import com.example.projectcv.dto.request.SignUpRequest;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.dto.response.SignInResponse;
import com.example.projectcv.entity.Candidate;
import com.example.projectcv.entity.Role;
import com.example.projectcv.entity.UserAccount;
import com.example.projectcv.exception.AppException;
import com.example.projectcv.exception.ErrorCode;
import com.example.projectcv.repository.AccountRepository;
import com.example.projectcv.repository.MemberRepository;
import com.example.projectcv.services.AuthenticationService;
import com.example.projectcv.services.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private MemberRepository memberRepository;
    @Override
    public ApiResponse<UserAccount> signup(SignUpRequest signUpRequest) {
        if(memberRepository.existsByEmail(signUpRequest.getEmail()))
        {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
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

    @Override
    public SignInResponse signIn(SignInRequest signinRequest) {
        String email = signinRequest.getEmail();;
        String password = signinRequest.getPassword();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));
        }catch (AuthenticationException ex)
        {
            throw new AppException(ErrorCode.SignIn_Fail);
        }

        Optional<UserAccount> optionalUser = accountRepository.findByMemberEmail(email);
        if (optionalUser.isPresent()) {
            UserAccount userAccount = optionalUser.get();
            var jwt = jwtService.generateToken(userAccount);

            SignInResponse signInResponse = new SignInResponse();
            signInResponse.setToken(jwt);
            return signInResponse;
            // Proceed with the authentication process
        } else {
            System.out.println("fail sigin");
            throw new AppException(ErrorCode.SignIn_Fail);
        }
    } ;


}
