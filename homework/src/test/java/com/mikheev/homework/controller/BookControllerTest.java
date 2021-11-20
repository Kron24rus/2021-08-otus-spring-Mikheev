package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.AuthorDto;
import com.mikheev.homework.controller.dto.BookDto;
import com.mikheev.homework.controller.dto.GenreDto;
import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookControllerTest {

    @MockBean
    BookRepository bookRepository;
    @MockBean
    CommentRepository commentRepository;

    @Autowired
    private RouterFunction<ServerResponse> route;

    @Autowired
    private ModelMapper modelMapper;

    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToRouterFunction(route).build();
    }

    @Test
    void getAllBooks_responseBodyShouldContainThreeBooks() {
        when(bookRepository.findAll()).thenReturn(Flux.just(new Book(), new Book(), new Book()));
        webTestClient.get()
                .uri("/api/library/book")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BookDto.class)
                .hasSize(3);
    }

    @Test
    void getBookById_responseBodyShouldContainSingleBookDtoWithComments() {
        Book foundBook = new Book();
        foundBook.setId("0");
        foundBook.setTitle("comedyBook");
        foundBook.setAuthor(new Author());
        foundBook.setGenre(new Genre());
        when(commentRepository.findByBookId("0")).thenReturn(Flux.just(new Comment(), new Comment()));
        when(bookRepository.findById("0")).thenReturn(Mono.just(foundBook));
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/library/book/{id}").build("0"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookDto.class)
                .value(bookDto -> {
                    assertEquals("comedyBook", bookDto.getTitle());
                    assertEquals("0", bookDto.getId());
                    assertEquals(2, bookDto.getComments().size());
                    assertNotNull(bookDto.getAuthor());
                    assertNotNull(bookDto.getGenre());
                });
    }

    @Test
    void createBook() {
        AuthorDto authorDto = new AuthorDto("0", "AuthorOfDetectiveAndComedy");
        GenreDto genreDto = new GenreDto("2", "criminal");
        BookDto bookDtoBody = new BookDto();
        bookDtoBody.setTitle("Test Title");
        bookDtoBody.setAuthor(authorDto);
        bookDtoBody.setGenre(genreDto);
        Book bookToSave = modelMapper.map(bookDtoBody, Book.class);
        Book savedBook = new Book();
        savedBook.setId("123");
        savedBook.setTitle(bookToSave.getTitle());
        savedBook.setGenre(bookToSave.getGenre());
        savedBook.setAuthor(bookToSave.getAuthor());
        when(bookRepository.insert(bookToSave)).thenReturn(Mono.just(savedBook));
        webTestClient.post()
                .uri(uriBuilder -> uriBuilder.path("/api/library/book").build())
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bookDtoBody))
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookDto.class)
                .value(bookDto -> {
                    assertEquals("123", bookDto.getId());
                    assertEquals("Test Title", bookDto.getTitle());
                });
    }
}