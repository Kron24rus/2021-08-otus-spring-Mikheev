package com.mikheev.homework.controller;

import com.mikheev.homework.controller.dto.AuthorDto;
import com.mikheev.homework.service.AuthorService;
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
public class AuthorController {

    private final AuthorService authorService;
    private final ModelMapper modelMapper;

    @GetMapping("/author")
    public List<AuthorDto> authorList() {
        return authorService.getAllAuthors().stream()
                .map(author -> modelMapper.map(author, AuthorDto.class)).collect(Collectors.toList());
    }
}
