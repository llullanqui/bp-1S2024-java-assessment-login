package com.pichincha.chapterdesarrollo.chdmsaassessmentjava2024S1login.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.validHours}")
    private int validHours;

    public int getAssessmentTokenValidTime() {
        return this.validHours * 3600 * 1000;
    }

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + getAssessmentTokenValidTime()))
                .signWith(Keys.hmacShaKeyFor(this.secret.getBytes()))
                .compact();
    }
}
