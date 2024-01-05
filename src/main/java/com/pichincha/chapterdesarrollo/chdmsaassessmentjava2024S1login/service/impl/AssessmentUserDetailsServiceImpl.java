package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.impl;

import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.domain.AssessmentUser;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.repository.AssessmentUserRepository;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssessmentUserDetailsServiceImpl implements UserDetailsService {

    private final AssessmentUserRepository repository;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AssessmentUser user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(Constants.USERNAME_NOT_FOUND_MESSAGE));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
