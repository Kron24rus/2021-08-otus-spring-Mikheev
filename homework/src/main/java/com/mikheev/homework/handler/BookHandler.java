package com.mikheev.homework.handler;

import com.mikheev.homework.controller.dto.*;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import com.mikheev.homework.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@RequiredArgsConstructor
@Component
public class BookHandler {

    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public Mono<ServerResponse> getAllBooks(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(bookRepository.findAll().map(book -> modelMapper.map(book, BookDto.class)), BookDto.class);
    }

    public Mono<ServerResponse> getBookById(ServerRequest request) {
        String bookId = request.pathVariable("id");
        Mono<BookDto> bookMono = bookRepository.findById(bookId).map(book -> modelMapper.map(book, BookDto.class));
        Mono<List<CommentDto>> commentsMono = commentRepository.findByBookId(bookId)
                .map(comment -> modelMapper.map(comment, CommentDto.class)).collectList();
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(Mono.zip(bookMono, commentsMono, this::appendComments), BookDto.class);
    }

    public Mono<ServerResponse> getLibraryAssociations(ServerRequest request) {
        Mono<List<AuthorDto>> authors = authorRepository.findAll()
                .map(author -> modelMapper.map(author, AuthorDto.class)).collectList();
        Mono<List<GenreDto>> genres = genreRepository.findAll()
                .map(genre -> modelMapper.map(genre, GenreDto.class)).collectList();
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(Mono.zip(authors, genres, this::toAssociationsDto), AssociationsDto.class);
    }

    public Mono<ServerResponse> addBook(ServerRequest request) {
        Mono<BookDto> savedBookDto = request.bodyToMono(BookDto.class)
                .map(bookDto -> modelMapper.map(bookDto, Book.class))
                .flatMap(bookRepository::insert)
                .map(book -> modelMapper.map(book, BookDto.class));
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(savedBookDto, BookDto.class);
    }

    public Mono<ServerResponse> updateBook(ServerRequest request) {
        Mono<BookDto> updateBookDto = request.bodyToMono(BookDto.class)
                .map(bookDto -> modelMapper.map(bookDto, Book.class))
                .flatMap(bookRepository::save)
                .map(book -> modelMapper.map(book, BookDto.class));
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(updateBookDto, BookDto.class);
    }

    public Mono<ServerResponse> deleteBook(ServerRequest request) {
        String bookId = request.pathVariable("id");
        return bookRepository.deleteByIdCascadeComments(bookId).then(ok().build());
    }

    private BookDto appendComments(BookDto book, List<CommentDto> comments) {
        book.setComments(comments);
        return book;
    }

    private AssociationsDto toAssociationsDto(List<AuthorDto> authors, List<GenreDto> genres) {
        return new AssociationsDto(authors, genres);
    }
}
