package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.domain;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "USERS")
public class AssessmentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

}
