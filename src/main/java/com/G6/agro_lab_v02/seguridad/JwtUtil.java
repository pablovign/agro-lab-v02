package com.G6.agro_lab_v02.seguridad;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration-ms}")
    private long expirationMs;

    private Algorithm algorithm() {
        return Algorithm.HMAC256(secret);
    }

    public String generateToken(String subject) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);
        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(now)
                .withExpiresAt(expiry)
                .sign(algorithm());
    }

    public String extractSubject(String token) {
        return JWT.require(algorithm()).build().verify(token).getSubject();
    }

    public boolean isValid(String token) {
        try {
            JWT.require(algorithm()).build().verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
