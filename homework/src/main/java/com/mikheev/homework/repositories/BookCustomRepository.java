package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Book;
import reactor.core.publisher.Mono;

public interface BookCustomRepository {

    Mono<Book> findByIdWithComments(String id);

    void deleteByIdCascadeComments(String id);
}
