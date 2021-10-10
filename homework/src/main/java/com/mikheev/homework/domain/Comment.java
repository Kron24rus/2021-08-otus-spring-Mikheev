package com.mikheev.homework.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "comments")
public class Comment {

    @Id
    private String id;

    private String text;

    @DBRef(lazy = true)
    private Book book;

    public Comment() {
    }

    public Comment(String id, String text, Book book) {
        this.id = id;
        this.text = text;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
