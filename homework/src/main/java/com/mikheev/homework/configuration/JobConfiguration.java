package com.mikheev.homework.configuration;

import com.mikheev.homework.domain.Author;
import com.mikheev.homework.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class JobConfiguration {

    private final AuthorRepository authorRepository;

    @StepScope
    @Bean
    public RepositoryItemReader<Author> authorRepositoryItemReader() {
        RepositoryItemReader<Author> repositoryItemReader = new RepositoryItemReader<>();
        repositoryItemReader.setRepository(authorRepository);
        repositoryItemReader.setName("authorRepositoryReader");
        repositoryItemReader.setMethodName("findAll");
        return repositoryItemReader;
    }
}
