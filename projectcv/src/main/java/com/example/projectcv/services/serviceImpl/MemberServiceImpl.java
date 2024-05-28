package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.dto.response.ApiResponse;
import com.example.projectcv.entity.Member;
import com.example.projectcv.repository.AccountRepository;
import com.example.projectcv.repository.MemberRepository;
import com.example.projectcv.services.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
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
            throw new RuntimeException("Member not found");
        }


    }
}
