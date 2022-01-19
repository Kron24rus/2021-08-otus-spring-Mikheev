package com.mikheev.homework.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssociationsDto {

    private List<AuthorDto> authors;
    private List<GenreDto> genres;
}
