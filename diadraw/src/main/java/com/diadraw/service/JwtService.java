package com.diadraw.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final String SIGNING_KEY = "DiaDrawDenkoSigningSecretKey12345678";
    private final long EXPIRATION_MILLIS = 3600000;

    public String generateJwtToken(String email, String phoneNumber) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_MILLIS);

        Key key = Keys.hmacShaKeyFor(SIGNING_KEY.getBytes());

        return Jwts.builder()
                .setSubject(email)
                .claim("phone_number", phoneNumber)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
