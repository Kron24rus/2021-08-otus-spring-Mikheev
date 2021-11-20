package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.GenreDto;
import com.mikheev.homework.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class GenreController {

    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    @GetMapping("/genre")
    public Flux<GenreDto> genreList() {
        return genreRepository.findAll()
                .map(genre -> modelMapper.map(genre, GenreDto.class));
    }
}
