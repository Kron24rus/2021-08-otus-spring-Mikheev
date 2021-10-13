package com.mikheev.homework.shell;

import com.mikheev.homework.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@RequiredArgsConstructor
@ShellComponent
public class LibraryApplicationAuthorCommands {

    private final AuthorService authorService;

    @ShellMethod(value = "Display author with specified id", key = {"getauthor"})
    public String displayAuthorWithId(String id) {
        return authorService.getAuthorAsString(id);
    }

    @ShellMethod(value = "Display all authors", key = {"getallauthors"})
    public String displayAllAuthors() {
        return authorService.getAllAuthorsAsString();
    }
}
