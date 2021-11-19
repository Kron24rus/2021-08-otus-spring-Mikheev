package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.AuthorDto;
import com.mikheev.homework.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/library")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @GetMapping("/author")
    public Flux<AuthorDto> authorList() {
        return authorRepository.findAll()
                .map(author -> modelMapper.map(author, AuthorDto.class));
    }
}
