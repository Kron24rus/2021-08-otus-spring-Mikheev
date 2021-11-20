package com.mikheev.homework.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @DBRef(lazy = true)
    private Book book;
}
