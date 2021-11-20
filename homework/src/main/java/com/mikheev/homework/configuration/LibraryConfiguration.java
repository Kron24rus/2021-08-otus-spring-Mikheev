package com.mikheev.homework.configuration;

import com.github.cloudyrock.spring.v5.EnableMongock;
import com.mikheev.homework.handler.BookHandler;
import com.mikheev.homework.repositories.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@EnableMongock
@EnableMongoRepositories(basePackageClasses = AuthorRepository.class)
@Configuration
public class LibraryConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public RouterFunction<ServerResponse> bookRoutes(BookHandler bookHandler) {
        return route().path("/api/library", builder ->
                builder
                        .GET("/book", bookHandler::getAllBooks)
                        .GET("/book/{id}", bookHandler::getBookById)
                        .GET("/associations", bookHandler::getLibraryAssociations)
                        .POST("/book", bookHandler::addBook)
                        .PUT("/book", bookHandler::updateBook)
                        .DELETE("/book/{id}", bookHandler::deleteBook))
                .build();
    }
}
