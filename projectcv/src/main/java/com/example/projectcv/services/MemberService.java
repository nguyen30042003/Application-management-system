package com.example.projectcv.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService {
   UserDetailsService userDetailsService();
}
