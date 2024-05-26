package com.example.projectcv.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    public boolean isTokenValid(String token, UserDetails userDetails);

}
