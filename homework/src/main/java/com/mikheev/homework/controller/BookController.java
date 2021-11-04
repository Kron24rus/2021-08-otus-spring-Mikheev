package com.mikheev.homework.controller;

import com.mikheev.homework.domain.Book;
import com.mikheev.homework.service.AuthorService;
import com.mikheev.homework.service.BookService;
import com.mikheev.homework.service.CommentService;
import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") long id) {
        return bookService.getBookWithAllAssociations(id);
    }

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
    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
    }
}
