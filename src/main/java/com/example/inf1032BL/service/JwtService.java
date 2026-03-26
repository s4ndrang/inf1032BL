package com.example.inf1032BL.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String getJwtToken(HttpServletRequest request);
    UserDetails extractUser(String token);
}
