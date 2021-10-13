package com.mikheev.homework.service.impl;


import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.GenreRepository;
import com.mikheev.homework.service.BookService;
import com.mikheev.homework.utils.EntityFormatterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Override
    public String getAllBooksAsString() {
        List<Book> books = bookRepository.findAll();
        return EntityFormatterUtils.prettyPrintEntity(books, "Books in data base");
    }

    @Override
    public String getBookAsString(String id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.map(book -> EntityFormatterUtils.prettyPrintEntity(Collections.singletonList(book), "Book with id: " + id))
                .orElseGet(() -> "No Book with id: " + id + "\n");
    }

    @Override
    public String addBook(String title, String authorId, String genreId) {
        StringBuilder resultMessage = new StringBuilder("Adding new book: ");

        Author author = getAuthorOrAppendNotFound(authorId, resultMessage);
        Genre genre = getGenreOrAppendNotFound(genreId, resultMessage);

        if (!Objects.isNull(author) && !Objects.isNull(genre)) {
            Book book = new Book(title, author, genre);
            Book savedBook = bookRepository.save(book);
            resultMessage.append("Inserted with id - ").append(savedBook.getId());
        }
        return resultMessage.toString();
    }

    @Override
    public String updateBook(String id, String title, String author_id, String genre_id) {
        StringBuilder resultMessage = new StringBuilder("Updating book with id: ").append(id).append(": ");
        boolean success = true;
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (title != null) {
                book.setTitle(title);
            }
            if (author_id != null) {
                Author author = getAuthorOrAppendNotFound(author_id, resultMessage);
                if (author != null) {
                    book.setAuthor(author);
                } else {
                    success = false;
                }
            }
            if (genre_id != null) {
                Genre genre = getGenreOrAppendNotFound(genre_id, resultMessage);
                if (genre != null) {
                    book.setGenre(genre);
                } else {
                    success = false;
                }
            }
            if (success) {
                bookRepository.save(book);
                resultMessage.append("Book updated");
            }
        }
        return resultMessage.toString();
    }

    @Override
    public String deleteBook(String id) {
        bookRepository.deleteByIdCascadeComments(id);
        return "Book with id: " + id + " removed from database";
    }

    private Author getAuthorOrAppendNotFound(String authorId, StringBuilder resultMessage) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        } else {
            resultMessage.append("Author with id: ").append(authorId).append(" not found. ");
            return null;
        }
    }

    private Genre getGenreOrAppendNotFound(String genreId, StringBuilder resultMessage) {
        Optional<Genre> optionalGenre = genreRepository.findById(genreId);
        if (optionalGenre.isPresent()) {
            return optionalGenre.get();
        } else {
            resultMessage.append("Genre with id: ").append(genreId).append(" not found. ");
            return null;
        }
    }
}
