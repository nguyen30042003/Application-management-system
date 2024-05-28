package com.example.projectcv.services;

import com.example.projectcv.dto.request.MemberDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.dto.response.PageResponse;
import com.example.projectcv.entity.Member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface MemberService {
   UserDetailsService userDetailsService();

   ApiResponse<Member> getMemberById(Long id);


   Page<Member> getMembers(Pageable pageable);

   ApiResponse<Member> updateMember(Long id, MemberDTO memberDTO);
}
