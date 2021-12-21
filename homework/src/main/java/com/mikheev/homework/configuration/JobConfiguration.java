package com.mikheev.homework.configuration;

import com.mikheev.homework.domain.Author;
import com.mikheev.homework.domain.Book;
import com.mikheev.homework.domain.Comment;
import com.mikheev.homework.domain.Genre;
import com.mikheev.homework.repositories.AuthorRepository;
import com.mikheev.homework.repositories.BookRepository;
import com.mikheev.homework.repositories.CommentRepository;
import com.mikheev.homework.repositories.GenreRepository;
import com.mikheev.homework.service.MigrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashMap;

@RequiredArgsConstructor
@Configuration
public class JobConfiguration {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final MongoTemplate mongoTemplate;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public static final String MIGRATE_SQL_TO_MONGO_JOB = "migrateSqlToMongoJob";
    private static final int CHUNK_SIZE = 5;

    @StepScope
    @Bean
    public RepositoryItemReader<Author> authorRepositoryItemReader() {
        RepositoryItemReader<Author> repositoryItemReader = new RepositoryItemReader<>();
        repositoryItemReader.setRepository(authorRepository);
        repositoryItemReader.setName("authorRepositoryReader");
        repositoryItemReader.setMethodName("findAll");
        repositoryItemReader.setSort(new HashMap<>());
        return repositoryItemReader;
    }

    @StepScope
    @Bean
    public MongoItemWriter<com.mikheev.homework.mongo.domain.Author> authorMongoItemWriter() {
        return new MongoItemWriterBuilder<com.mikheev.homework.mongo.domain.Author>()
                .collection("authors")
                .template(mongoTemplate)
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Author, com.mikheev.homework.mongo.domain.Author> authorItemProcessor(MigrationService migrationService) {
        return migrationService::migrateAuthorEntity;
    }

    @Bean
    public Step migrateAuthorEntityStep(RepositoryItemReader<Author> reader,
                                        MongoItemWriter<com.mikheev.homework.mongo.domain.Author> writer,
                                        ItemProcessor<Author, com.mikheev.homework.mongo.domain.Author> itemProcessor) {
        return stepBuilderFactory.get("step1")
                .<Author, com.mikheev.homework.mongo.domain.Author>chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(itemProcessor)
                .writer(writer)
                .build();
    }

    @StepScope
    @Bean
    public RepositoryItemReader<Genre> genreRepositoryItemReader() {
        RepositoryItemReader<Genre> repositoryItemReader = new RepositoryItemReader<>();
        repositoryItemReader.setRepository(genreRepository);
        repositoryItemReader.setName("genreRepositoryItemReader");
        repositoryItemReader.setMethodName("findAll");
        repositoryItemReader.setSort(new HashMap<>());
        return repositoryItemReader;
    }

    @StepScope
    @Bean
    public MongoItemWriter<com.mikheev.homework.mongo.domain.Genre> genreMongoItemWriter() {
        return new MongoItemWriterBuilder<com.mikheev.homework.mongo.domain.Genre>()
                .collection("genres")
                .template(mongoTemplate)
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Genre, com.mikheev.homework.mongo.domain.Genre> genreItemProcessor(MigrationService migrationService) {
        return migrationService::migrateGenreEntity;
    }

    @Bean
    public Step migrateGenreEntityStep(RepositoryItemReader<Genre> reader,
                                        MongoItemWriter<com.mikheev.homework.mongo.domain.Genre> writer,
                                        ItemProcessor<Genre, com.mikheev.homework.mongo.domain.Genre> itemProcessor) {
        return stepBuilderFactory.get("step2")
                .<Genre, com.mikheev.homework.mongo.domain.Genre>chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(itemProcessor)
                .writer(writer)
                .build();
    }

    @StepScope
    @Bean
    public RepositoryItemReader<Book> bookRepositoryItemReader() {
        RepositoryItemReader<Book> repositoryItemReader = new RepositoryItemReader<>();
        repositoryItemReader.setRepository(bookRepository);
        repositoryItemReader.setName("bookRepositoryItemReader");
        repositoryItemReader.setMethodName("findAll");
        repositoryItemReader.setSort(new HashMap<>());
        return repositoryItemReader;
    }

    @StepScope
    @Bean
    public MongoItemWriter<com.mikheev.homework.mongo.domain.Book> bookMongoItemWriter() {
        return new MongoItemWriterBuilder<com.mikheev.homework.mongo.domain.Book>()
                .collection("books")
                .template(mongoTemplate)
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Book, com.mikheev.homework.mongo.domain.Book> bookItemProcessor(MigrationService migrationService) {
        return migrationService::migrateBookEntity;
    }

    @Bean
    public Step migrateBookEntityStep(RepositoryItemReader<Book> reader,
                                       MongoItemWriter<com.mikheev.homework.mongo.domain.Book> writer,
                                       ItemProcessor<Book, com.mikheev.homework.mongo.domain.Book> itemProcessor) {
        return stepBuilderFactory.get("step3")
                .<Book, com.mikheev.homework.mongo.domain.Book>chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(itemProcessor)
                .writer(writer)
                .build();
    }

    @StepScope
    @Bean
    public RepositoryItemReader<Comment> commentRepositoryItemReader() {
        RepositoryItemReader<Comment> repositoryItemReader = new RepositoryItemReader<>();
        repositoryItemReader.setRepository(commentRepository);
        repositoryItemReader.setName("commentRepositoryItemReader");
        repositoryItemReader.setMethodName("findAll");
        repositoryItemReader.setSort(new HashMap<>());
        return repositoryItemReader;
    }

    @StepScope
    @Bean
    public MongoItemWriter<com.mikheev.homework.mongo.domain.Comment> commentMongoItemWriter() {
        return new MongoItemWriterBuilder<com.mikheev.homework.mongo.domain.Comment>()
                .collection("comments")
                .template(mongoTemplate)
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Comment, com.mikheev.homework.mongo.domain.Comment> commentItemProcessor(MigrationService migrationService) {
        return migrationService::migrateCommentEntity;
    }

    @Bean
    public Step migrateCommentEntityStep(RepositoryItemReader<Comment> reader,
                                       MongoItemWriter<com.mikheev.homework.mongo.domain.Comment> writer,
                                       ItemProcessor<Comment, com.mikheev.homework.mongo.domain.Comment> itemProcessor) {
        return stepBuilderFactory.get("step4")
                .<Comment, com.mikheev.homework.mongo.domain.Comment>chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(itemProcessor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job migrateSqlToMongoJob(Step migrateAuthorEntityStep, Step migrateGenreEntityStep,
                                    Step migrateBookEntityStep, Step migrateCommentEntityStep) {
        return jobBuilderFactory.get(MIGRATE_SQL_TO_MONGO_JOB)
                .flow(migrateAuthorEntityStep)
                .next(migrateGenreEntityStep)
                .next(migrateBookEntityStep)
                .next(migrateCommentEntityStep)
                .end()
                .build();
    }
}
