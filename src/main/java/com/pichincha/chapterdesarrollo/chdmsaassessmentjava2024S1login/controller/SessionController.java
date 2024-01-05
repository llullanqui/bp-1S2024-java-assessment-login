package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.controller;

import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.LoginService;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto.request.LoginRequest;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto.LoginResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessment/api/v1/session")
@AllArgsConstructor
public class SessionController {

    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(loginService.login(loginRequest));
    }

}
