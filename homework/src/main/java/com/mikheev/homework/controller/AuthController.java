package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.LoginRequestDto;
import com.mikheev.homework.controller.dto.LoginResponseDto;
import com.mikheev.homework.controller.dto.RefreshRequestDto;
import com.mikheev.homework.controller.dto.RefreshResponseDto;
import com.mikheev.homework.domain.RefreshToken;
import com.mikheev.homework.domain.Role;
import com.mikheev.homework.domain.User;
import com.mikheev.homework.exception.RefreshTokenException;
import com.mikheev.homework.security.jwt.JwtTokenUtil;
import com.mikheev.homework.security.services.RefreshTokenService;
import com.mikheev.homework.security.services.UserDetailsImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final RefreshTokenService refreshTokenService;

    @CircuitBreaker(name = "authController")
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        String jwtToken = jwtTokenUtil.generateJwtToken(userDetails.getUsername(), roles);

        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getUsername());

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, jwtToken)
                .body(new LoginResponseDto(jwtToken, refreshToken.getToken(), userDetails.getUsername(), roles));
    }

    @CircuitBreaker(name = "authController")
    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshRequestDto refreshRequestDto) {
        String requestRefreshToken = refreshRequestDto.getRefreshToken();

        RefreshToken refreshToken = refreshTokenService.findByToken(requestRefreshToken)
                .orElseThrow(() -> new RefreshTokenException(requestRefreshToken, "No token in database"));

        refreshTokenService.verifyRefreshToken(refreshToken);

        User user = refreshToken.getUser();
        List<String> roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toList());
        String jwtToken = jwtTokenUtil.generateJwtToken(user.getUsername(), roles);

        return ResponseEntity.ok(new RefreshResponseDto(jwtToken, requestRefreshToken));
    }
}
