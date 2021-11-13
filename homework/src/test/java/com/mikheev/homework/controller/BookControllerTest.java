package com.mikheev.homework.controller;


import com.mikheev.homework.domain.Book;
import com.mikheev.homework.exception.NotFoundException;
import com.mikheev.homework.service.AuthorService;
import com.mikheev.homework.service.BookService;
import com.mikheev.homework.service.CommentService;
import com.mikheev.homework.service.GenreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(BookController.class)
public class BookControllerTest {

//    private static final String BOOK_TITLE = "booktitle";
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BookService bookService;
//    @MockBean
//    private AuthorService authorService;
//    @MockBean
//    private GenreService genreService;
//
//    @Test
//    void get_all_books_should_return_OK() throws Exception {
//        Book book1 = new Book();
//        book1.setTitle(BOOK_TITLE);
//        Book book2 = new Book();
//        book2.setTitle(BOOK_TITLE);
//        given(bookService.getAllBooks()).willReturn(List.of(book1, book2));
//        this.mockMvc.perform(get("/api/library/book"))
//                .andExpect(status().isOk());
//        verify(bookService, times(1)).getAllBooks();
//    }
//
//    @Test
//    void get_book_by_not_exist_id_should_return_404() throws Exception {
//        given(bookService.getBookWithAllAssociations("200")).willThrow(new NotFoundException());
//        mockMvc.perform(get("/api/library/book/200"))
//                .andExpect(status().isNotFound());
//    }
}
