package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {

    @JsonProperty
    private String message;

}
