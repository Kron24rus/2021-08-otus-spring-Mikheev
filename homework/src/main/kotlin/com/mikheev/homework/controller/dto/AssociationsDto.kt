package com.mikheev.homework.controller.dto

class AssociationsDto(authorsDto: List<AuthorDto>, genresDto: List<GenreDto>) {

    val authors: List<AuthorDto> = authorsDto
    val genres: List<GenreDto> = genresDto
}