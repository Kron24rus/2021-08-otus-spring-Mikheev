package com.mikheev.homework.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.*;

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

    public JwtUser getJwtUserFromToken(String jwtToken) {
        Claims body = Jwts.parser().setSigningKey(jwtConfiguration.getSecret()).parseClaimsJws(jwtToken).getBody();
        String username = body.getSubject();

        List<GrantedAuthority> authorities;

        Collection<?> roles = body.get("ROLES", Collection.class);
        if (null != roles) {
            authorities = new ArrayList<>(roles.size());
            for (Object role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.toString()));
            }
        } else {
            authorities = Collections.emptyList();
        }

        return new JwtUser(username, authorities);
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
