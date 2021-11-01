package com.mikheev.homework.controller;


import com.mikheev.homework.domain.Book;
import com.mikheev.homework.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    private static final String BOOK_TITLE = "booktitle";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void test() throws Exception {
        Book book1 = new Book();
        book1.setTitle(BOOK_TITLE);
        Book book2 = new Book();
        book2.setTitle(BOOK_TITLE);
        given(bookService.getAllBooks()).willReturn(List.of(book1, book2));
        this.mockMvc.perform(get("/booklist"))
                .andExpect(status().isOk()).andExpect(content().string(containsString(BOOK_TITLE)));
        verify(bookService, times(1)).getAllBooks();
    }
}
