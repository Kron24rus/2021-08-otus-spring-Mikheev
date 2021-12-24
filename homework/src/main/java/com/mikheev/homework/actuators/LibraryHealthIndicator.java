package com.mikheev.homework.actuators;

import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LibraryHealthIndicator implements HealthIndicator {

    private static final int LIBRARY_AUTHORS_SIZE = 3;
    private static final int LIBRARY_GENRES_SIZE = 4;

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Override
    public Health health() {

        List<Author> authors = authorRepository.findAll();
        List<Genre> genres = genreRepository.findAll();

        Health.Builder libraryHealth = Health.up().withDetail("message", "Library in healthy state");
        StringBuilder downMessage = new StringBuilder();
        boolean libraryDown = false;

        if (authors.size() != LIBRARY_AUTHORS_SIZE) {
            downMessage.append("Library have wrong authors size: ").append(authors.size()).append(" ");
            libraryHealth = Health.down();
            libraryDown = true;
        }

        if (genres.size() != LIBRARY_GENRES_SIZE) {
            downMessage.append("Library have wrong genres size: ").append(genres.size()).append(" ");
            libraryHealth = Health.down();
            libraryDown = true;
        }

        if (libraryDown) {
            return libraryHealth.withDetail("message", downMessage.toString()).build();
        }
        return libraryHealth.build();
    }
}
