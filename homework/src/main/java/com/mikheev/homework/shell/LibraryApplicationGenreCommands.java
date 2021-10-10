package com.mikheev.homework.shell;

import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@RequiredArgsConstructor
@ShellComponent
public class LibraryApplicationGenreCommands {

    private final GenreService genreService;

    @ShellMethod(value = "Display genre with specified id", key = {"getgenre"})
    public String displayGenreWithId(String id) {
        return genreService.getGenreAsString(id);
    }

    @ShellMethod(value = "Display all genres", key = {"getallgenres"})
    public String displayAll() {
        return genreService.getAllGenresAsString();
    }
}
