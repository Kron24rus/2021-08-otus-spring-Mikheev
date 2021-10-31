package com.mikheev.homework.controller;

import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class GenreController {

    private final GenreService genreService;

    @GetMapping("/genrelist")
    public String genreListPage(Model model) {
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        return "genrelist";
    }
}
