package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.request.MemberDTO;
import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Member;
import com.example.projectcv.exception.AppException;
import com.example.projectcv.exception.ErrorCode;
import com.example.projectcv.repository.AccountRepository;
import com.example.projectcv.repository.MemberRepository;
import com.example.projectcv.services.MemberService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    AccountRepository accountRepository;
    MemberRepository memberRepository;
    @Override
    public UserDetailsService userDetailsService() {
       return new UserDetailsService() {
           @Override
           public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
              return accountRepository.findByMemberEmail(username).orElseThrow(
                      () -> new UsernameNotFoundException(username + "not found"));
           }
       };
    }

    @Override
    @PostAuthorize("returnObject.data.email == authentication.name")
    public ApiResponse<Member> getMemberById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if(member.isPresent()) {
            ApiResponse<Member> apiResponse = new ApiResponse<>();
            apiResponse.setData(member.get());
            return apiResponse;
        } else {
            throw new AppException(ErrorCode.MEMBER_NOT_EXISTED);

        }
    }


    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Override
    public Page<Member> getMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    @Override
    @PreAuthorize("#id == authentication.principal.id")
    public ApiResponse<Member> updateMember(Long id, MemberDTO memberDTO) {
        Member member = memberRepository.findById(id).
                orElseThrow(() ->
                new RuntimeException("Member not found"));
        member.setAddress(memberDTO.getAddress());
        member.setEmail(memberDTO.getEmail());
        member.setName(memberDTO.getName());
        member.setContact(memberDTO.getContact());
        memberRepository.save(member);
        return new ApiResponse<>(member);
    }




}
