package com.mikheev.homework.controller;

import com.mikheev.homework.domain.Book;
import com.mikheev.homework.service.AuthorService;
import com.mikheev.homework.service.BookService;
import com.mikheev.homework.service.CommentService;
import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;
    private final CommentService commentService;

    @GetMapping("/book")
    public List<Book> bookList() {
        return bookService.getAllBooks();
    }

//    @GetMapping("/book/{id}")
//    public Book getBook() {
//
//    }

//    @GetMapping("/bookpage")
//    public String bookPage(@RequestParam("id") long id, Model model) {
//        Book book = bookService.getBookWithAuthorAndGenre(id);
//        List<Comment> comments = commentService.getBookComments(id);
//        model.addAttribute("book", book);
//        model.addAttribute("comments" , comments);
//        return "bookpage";
//    }
//
//    @GetMapping("/addbook")
//    public String addBookPage(Model model) {
//        List<Author> authors = authorService.getAllAuthors();
//        List<Genre> genres = genreService.getAllGenres();
//        model.addAttribute("book", new Book());
//        model.addAttribute("authors", authors);
//        model.addAttribute("genres", genres);
//        return "addbook";
//    }
//
//    @PostMapping("addbook")
//    public String addBook(Book book, Model model) {
//        bookService.addBook(book);
//        return "redirect:/booklist";
//    }
//
//    @GetMapping("/editbook")
//    public String editBookPage(@RequestParam("id") long id, Model model) {
//        model.addAttribute("book", bookService.getBookWithAuthorAndGenre(id));
//        model.addAttribute("authors", authorService.getAllAuthors());
//        model.addAttribute("genres", genreService.getAllGenres());
//        return "editbook";
//    }
//
//    @PostMapping("/editbook")
//    public String editBook(Book book, Model model) {
//        Book savedBook = bookService.updateBook(book);
//        model.addAttribute("book", savedBook);
//        return "redirect:/bookpage?id=" + book.getId();
//    }
//
//    @PostMapping("/deletebook")
//    public String deleteBook(@RequestParam("id") long id, Model model) {
//        bookService.deleteBook(id);
//        return "redirect:/booklist";
//    }
}
