package com.mikheev.homework.utils.mongo;

import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BookCascadeEventListeners extends AbstractMongoEventListener<Book> {

    private final MongoOperations mongoOperations;

    public BookCascadeEventListeners(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<Book> event) {
        if (Book.class.equals(event.getType())) {
            var document = event.getDocument();
            if (Objects.nonNull(document)) {
                Query query = new Query();
                query.addCriteria(Criteria.where("book.$id").is(document.get("_id")));
                mongoOperations.findAllAndRemove(query, Comment.class);
            }
        }
    }
}
