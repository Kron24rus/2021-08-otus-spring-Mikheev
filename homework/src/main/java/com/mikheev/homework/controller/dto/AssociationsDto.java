package com.mikheev.homework.controller.dto;

import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AssociationsDto {

    List<Author> authors;
    List<Genre> genres;
}
