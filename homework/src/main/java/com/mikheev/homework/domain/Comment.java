package com.mikheev.homework.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"book"})
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;

    private String text;

    @DBRef(lazy = true)
    private Book book;
}
