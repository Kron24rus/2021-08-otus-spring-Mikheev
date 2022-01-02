package com.mikheev.homework.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class JwtUser {

    String username;
    Collection<? extends GrantedAuthority> authorities;
}
