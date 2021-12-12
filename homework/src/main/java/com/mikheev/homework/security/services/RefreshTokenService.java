package com.mikheev.homework.security.services;

import com.mikheev.homework.domain.RefreshToken;
import com.mikheev.homework.exception.RefreshTokenException;
import com.mikheev.homework.repositories.RefreshTokenRepository;
import com.mikheev.homework.repositories.UserRepository;
import com.mikheev.homework.security.jwt.JwtConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {

    private final JwtConfiguration jwtConfiguration;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(userRepository.findByUsername(username));
        refreshToken.setExpirationDate(new Date((new Date()).getTime() + jwtConfiguration.getRefreshExpirationTime()));
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken = refreshTokenRepository.save(refreshToken);

        return refreshToken;
    }

    public void verifyRefreshToken(RefreshToken refreshToken) {
        if (refreshToken.getExpirationDate().compareTo(new Date()) < 0) {
            refreshTokenRepository.delete(refreshToken);
            throw new RefreshTokenException(refreshToken.getToken(), "Refresh token was expired");
        }
    }
}
