package com.mikheev.homework.mongo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"book"})
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;

    private String text;

    @DBRef(lazy = true)
    private Book book;
}
