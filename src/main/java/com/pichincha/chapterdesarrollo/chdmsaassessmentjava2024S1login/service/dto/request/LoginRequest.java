package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    @JsonProperty
    @NotBlank
    private String username;

    @JsonProperty
    @NotBlank
    private String password;

}
