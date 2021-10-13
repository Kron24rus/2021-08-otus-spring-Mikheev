package com.mikheev.homework.shell;

import com.mikheev.homework.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@RequiredArgsConstructor
@ShellComponent
public class LibraryApplicationBookCommands {

    private final BookService bookService;

    @ShellMethod(value = "Display book with specified id", key = {"getbook"})
    public String displayBookWithId(String id) {
        return bookService.getBookAsString(id);
    }

    @ShellMethod(value = "Display all books", key = {"getallbooks"})
    public String displayAll() {
        return bookService.getAllBooksAsString();
    }

    @ShellMethod(value = "Add new book", key = {"addbook"})
    public String addNewBook(String title, String author_id, String genre_id) {
        return bookService.addBook(title, author_id, genre_id);
    }

    @ShellMethod(value = "Delete book", key = {"deletebook"})
    public String deleteBook(String id) {
        return bookService.deleteBook(id);
    }

    @ShellMethod(value = "Update book: pass null if you don't want to update this field", key = {"updatebook"})
    public String updateBook(@ShellOption(value = "--id") String id,
                             @ShellOption(value = "--title", defaultValue = ShellOption.NULL) String title,
                             @ShellOption(value = "--authorId", defaultValue = ShellOption.NULL) String authorId,
                             @ShellOption(value = "--genreId", defaultValue = ShellOption.NULL) String genreId) {
        return bookService.updateBook(id, title, authorId, genreId);
    }
}
