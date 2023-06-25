package com.diadraw.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final String SIGNING_KEY = "DiaDrawDenkoSigningSecretKey12345678";
    private final long EXPIRATION_MILLIS = 3600000;

    public String generateJwtToken(final String email, final String phoneNumber) {
        final Date now = new Date();
        final Date expiration = new Date(now.getTime() + EXPIRATION_MILLIS);

        final Key key = Keys.hmacShaKeyFor(SIGNING_KEY.getBytes());

        return Jwts.builder()
                .setSubject(email)
                .claim("phone_number", phoneNumber)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String validateJwtToken(final String token) throws Exception {
        try {
            final Key key = Keys.hmacShaKeyFor(SIGNING_KEY.getBytes());

            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

            final Date expirationDate = claims.getBody().getExpiration();

//            if(expirationDate.after(new Date()))
//            {
//                throw new TokenExpiredException();
//            }

            return claims.getBody().getSubject();
        } catch (Exception e) {
            logger.error("Failed to validate token: " + token + " with error: " + e);

            throw e;
        }
    }
}
