package com.mikheev.homework.service;

public interface BookService {

    String getAllBooksAsString();

    String getBookAsString(String id);

    String addBook(String title, String authorId, String genreId);

    String deleteBook(String id);

    String updateBook(String id, String title, String author_id, String genre_id);
}
