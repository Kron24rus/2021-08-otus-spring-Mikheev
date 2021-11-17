package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.AssociationsDto;
import com.mikheev.homework.controller.dto.BookDto;
import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import com.mikheev.homework.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class BookController {

   private final AuthorRepository authorRepository;
   private final GenreRepository genreRepository;
   private final BookRepository bookRepository;
   private final CommentRepository commentRepository;

    @GetMapping("/book")
    public Flux<Book> bookList() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Mono<BookDto> getBook(@PathVariable("id") String id) {
        Mono<Book> bookMono = bookRepository.findById(id);
        Mono<List<Comment>> commentsMono = commentRepository.findByBookId(id).collectList();
        return Mono.zip(bookMono, commentsMono, this::toBookDto);
    }

    @GetMapping("/book/associations")
    public Mono<AssociationsDto> loadEditCreateAssociations() {
        Mono<List<Author>> authors = authorRepository.findAll().collectList();
        Mono<List<Genre>> genres = genreRepository.findAll().collectList();
        return Mono.zip(authors, genres, this::toAssociationsDto);
    }

    @PostMapping("/book")
    public Mono<Book> addBook(@RequestBody Book book) {
        return bookRepository.insert(book);
    }

    @PutMapping("/book")
    public Mono<Book> updateBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") String id) {
        bookRepository.deleteByIdCascadeComments(id);
    }

    private BookDto toBookDto(Book book, List<Comment> comments) {
        return new BookDto(book, comments);
    }

    private AssociationsDto toAssociationsDto(List<Author> authors, List<Genre> genres) {
        return new AssociationsDto(authors, genres);
    }
}
