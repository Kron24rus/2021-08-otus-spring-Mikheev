package com.mikheev.homework.shell;

import com.mikheev.homework.service.GenreService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class LibraryApplicationGenreCommands {

    private GenreService genreService;

    public LibraryApplicationGenreCommands(GenreService genreService) {
        this.genreService = genreService;
    }

    @ShellMethod(value = "Display genre with specified id", key = {"getgenre"})
    public String displayGenreWithId(long id) {
        return genreService.getGenreAsString(id);
    }

    @ShellMethod(value = "Display all genres", key = {"getallgenres"})
    public String displayAll() {
        return genreService.getAllGenresAsString();
    }
}
