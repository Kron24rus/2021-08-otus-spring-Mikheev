package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.GenreDto;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class GenreController {

    private final GenreService genreService;
    private final ModelMapper modelMapper;

    @GetMapping("/genre")
    public List<GenreDto> genreList() {
        return genreService.getAllGenres().stream()
                .map(genre -> modelMapper.map(genre, GenreDto.class)).collect(Collectors.toList());
    }
}
