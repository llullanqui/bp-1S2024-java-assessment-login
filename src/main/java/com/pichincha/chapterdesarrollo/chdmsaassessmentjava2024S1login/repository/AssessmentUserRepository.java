package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.repository;

import com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.domain.AssessmentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentUserRepository extends JpaRepository<AssessmentUser, String> {
}
