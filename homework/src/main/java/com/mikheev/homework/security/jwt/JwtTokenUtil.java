package com.mikheev.homework.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenUtil {

    private final JwtConfiguration jwtConfiguration;

    public String generateJwtToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("ROLES", roles)
                .setIssuer(jwtConfiguration.getIssuer())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtConfiguration.getExpirationTime()))
                .signWith(SignatureAlgorithm.HS512, jwtConfiguration.getSecret())
                .compact();
    }

    public String getUserNameFromToken(String jwtToken) {
        return Jwts.parser().setSigningKey(jwtConfiguration.getSecret())
                .parseClaimsJws(jwtToken).getBody().getSubject();
    }

    public boolean validateJwtToken(String jwtToken) {
        try {
            Jwts.parser().setSigningKey(jwtConfiguration.getSecret()).parseClaimsJws(jwtToken);
            return true;
        } catch (Exception e) {
            log.error("Error during validating token: {}", e.getMessage());
        }
        return false;
    }
}
