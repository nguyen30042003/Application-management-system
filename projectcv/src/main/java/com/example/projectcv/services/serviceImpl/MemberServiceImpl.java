package com.example.projectcv.services.serviceImpl;

import com.example.projectcv.repository.AccountRepository;
import com.example.projectcv.repository.MemberRepository;
import com.example.projectcv.services.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    AccountRepository accountRepository;
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
}
