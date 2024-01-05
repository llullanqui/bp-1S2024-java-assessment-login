package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssessmentUserDto {

    @JsonProperty
    public String username;

    @JsonProperty
    public String password;

}
