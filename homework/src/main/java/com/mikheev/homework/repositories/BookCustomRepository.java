package com.mikheev.homework.repositories;

import com.mikheev.homework.domain.Book;

import java.util.Optional;

public interface BookCustomRepository {

    Optional<Book> findById(long id, String entityGraphName);
}
