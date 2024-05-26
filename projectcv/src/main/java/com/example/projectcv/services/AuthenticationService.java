package com.example.projectcv.services;

import com.example.projectcv.dto.request.SignUpRequest;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.UserAccount;

public interface AuthenticationService {

    ApiResponse<UserAccount> signup (SignUpRequest signUpRequest);
}
