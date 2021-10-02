package com.mikheev.homework.service;

public interface BookService {

    String getAllBooksAsString();

    String getBookAsString(long id);

    String addBook(String title, long authorId, long genreId);

    String deleteBook(long id);

    String updateBook(long id, String title, Long author_id, Long genre_id);
}
