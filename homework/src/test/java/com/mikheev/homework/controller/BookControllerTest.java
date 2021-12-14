package com.mikheev.homework.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.exception.NotFoundException;
import com.mikheev.homework.security.jwt.AuthEntryPointJwt;
import com.mikheev.homework.security.jwt.JwtTokenFilter;
import com.mikheev.homework.security.jwt.JwtTokenUtil;
import com.mikheev.homework.service.AuthorService;
import com.mikheev.homework.service.BookService;
import com.mikheev.homework.service.CommentService;
import com.mikheev.homework.service.GenreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
@ContextConfiguration(classes = BookController.class)
public class BookControllerTest {

    private static final String BOOK_TITLE = "booktitle";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;
    @MockBean
    private AuthorService authorService;
    @MockBean
    private GenreService genreService;
    @MockBean
    private CommentService commentService;
    @MockBean
    private ModelMapper modelMapper;

    @WithMockUser(
            username = "admin"
    )
    @Test
    void get_all_books_should_return_OK() throws Exception {
        Book book1 = new Book();
        book1.setTitle(BOOK_TITLE);
        Book book2 = new Book();
        book2.setTitle(BOOK_TITLE);
        given(bookService.getAllBooks()).willReturn(List.of(book1, book2));
        mockMvc.perform(get("/api/library/book"))
                .andExpect(status().isOk());
        verify(bookService, times(1)).getAllBooks();
    }

    @WithMockUser(
            username = "admin"
    )
    @Test
    void get_book_by_not_exist_id_should_return_404() throws Exception {
        given(bookService.getBookWithAllAssociations(200)).willThrow(new NotFoundException());
        mockMvc.perform(get("/api/library/book/200"))
                .andExpect(status().isNotFound());
    }

    @WithMockUser(
            username = "admin",
            roles = {"ADMIN"}
    )
    @Test
    void get_book_associations() throws Exception {
        given(authorService.getAllAuthors()).willReturn(List.of(new Author()));
        given(genreService.getAllGenres()).willReturn(List.of(new Genre()));
        mockMvc.perform(get("/api/library/associations"))
                .andExpect(status().isOk());
    }

    @WithMockUser(
            username = "admin",
            roles = {"ADMIN"}
    )
    @Test
    void add_new_book() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Book bookToSave = new Book();
        bookToSave.setTitle("new title");
        bookToSave.setGenre(new Genre());
        bookToSave.setAuthor(new Author());

        given(bookService.addBook(bookToSave)).willReturn(bookToSave);
        mockMvc.perform(post("/api/library/book")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookToSave)))
                .andExpect(status().isOk());
    }

    @WithMockUser(
            username = "moderator",
            roles = {"MODERATOR"}
    )
    @Test
    void update_book() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Book bookToSave = new Book();
        bookToSave.setTitle("new title");
        bookToSave.setGenre(new Genre());
        bookToSave.setAuthor(new Author());
        given(bookService.updateBook(bookToSave)).willReturn(bookToSave);
        mockMvc.perform(put("/api/library/book")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(bookToSave)))
                .andExpect(status().isOk());
    }

    @WithMockUser(
            username = "moderator",
            roles = {"MODERATOR"}
    )
    @Test
    void delete_book() throws Exception {
        mockMvc.perform(delete("/api/library/book/{id}", "1")
                .with(csrf()))
                .andExpect(status().isOk());
        verify(bookService, times(1)).deleteBook(1);
    }
}
