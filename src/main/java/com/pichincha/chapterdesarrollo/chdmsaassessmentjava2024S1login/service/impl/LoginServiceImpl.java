package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.impl;

import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.LoginService;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto.request.LoginRequest;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto.LoginResponse;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.util.Constants;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final AssessmentUserDetailsServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        authenticate(loginRequest);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        return LoginResponse.builder()
                .token(jwtUtil.generateToken(userDetails))
                .build();
    }

    private void authenticate(LoginRequest loginRequest) throws RuntimeException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (DisabledException e) {
            throw new RuntimeException(Constants.DISABLED_USER);
        } catch (BadCredentialsException e) {
            throw new RuntimeException(Constants.BAD_CREDENTIALS);
        } catch (Exception e) {
            throw new RuntimeException(Constants.COULD_NOT_AUTHENTICATE);
        }
    }

}
