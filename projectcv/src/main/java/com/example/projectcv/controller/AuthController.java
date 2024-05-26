package com.example.projectcv.controller;

import com.example.projectcv.dto.request.SignUpRequest;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.UserAccount;
import com.example.projectcv.services.AuthenticationService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ApiResponse<UserAccount> signUp(@RequestBody SignUpRequest signUpRequest) {
        return authenticationService.signup(signUpRequest);
    }
}
