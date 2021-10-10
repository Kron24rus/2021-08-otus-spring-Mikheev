package com.mikheev.homework.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collection = "authors")
public class Author {

    @Id
    private String id;

    private String name;

    public Author() {
    }
}
