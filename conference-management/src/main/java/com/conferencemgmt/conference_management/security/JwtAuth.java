package com.conferencemgmt.conference_management.security;

import com.conferencemgmt.conference_management.model.Personne;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtAuth {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    public String generateJwtToken(Personne personne) {
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .setSubject(personne.getUsername())
                .claim("role", personne.getRole().name())
                // Ensure this line is present
                .claim("conferencierId", personne.getId()) // Add this line to include conferencierId

                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day expiration
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    public String getSecretKey() {
        return secretKey;
    }
}
