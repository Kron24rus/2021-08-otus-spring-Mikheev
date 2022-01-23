package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.GenreRepository;
import com.mikheev.homework.service.GenreService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @CircuitBreaker(name = "genreService")
    @Transactional(readOnly = true)
    @Override
    public List<Genre> getAllGenres() {
        sleepRandomly();
        return genreRepository.findAll();
    }

    private void sleepRandomly() {
        Random random = new Random();
        int randomInt = random.nextInt(3) + 1;
        if (randomInt == 3) {
            System.out.println("Test action");
            try {
                System.out.println("Start sleep");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                e.printStackTrace();
            }
        }
    }
}
