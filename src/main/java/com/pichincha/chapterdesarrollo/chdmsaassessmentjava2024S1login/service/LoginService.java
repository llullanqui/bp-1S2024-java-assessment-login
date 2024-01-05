package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service;

import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto.request.LoginRequest;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest loginRequest);
}
