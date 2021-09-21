package com.mikheev.homework.shell;

import com.mikheev.homework.service.AuthorService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class LibraryApplicationAuthorCommands {

    private AuthorService authorService;

    public LibraryApplicationAuthorCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod(value = "Display author with specified id", key = {"getauthor"})
    public String displayAuthorWithId(long id) {
        return authorService.getAuthorAsString(id);
    }

    @ShellMethod(value = "Display all authors", key = {"getallauthors"})
    public String displayAllAuthors() {
        return authorService.getAllAuthorsAsString();
    }
}
