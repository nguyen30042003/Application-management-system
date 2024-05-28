package com.example.projectcv.services;

import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Member;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MemberService {
   UserDetailsService userDetailsService();

   ApiResponse<Member> getMemberById(Long id);





}
