package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.mapper;

import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.domain.AssessmentUser;
import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.service.dto.AssessmentUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssessmentUserMapper {

    AssessmentUserDto toDto(AssessmentUser user);

    AssessmentUser toEntity(AssessmentUserDto userDto);

}
