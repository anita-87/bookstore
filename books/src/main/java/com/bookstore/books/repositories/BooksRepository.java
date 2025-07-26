package com.bookstore.books.repositories;

import com.bookstore.books.models.Book;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.time.LocalDate;
import java.util.List;

@Repository
public class BooksRepository {

    private final DynamoDbTemplate dynamoDbTemplate;

    public BooksRepository(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    public List<Book> getAllBooks() {
        return dynamoDbTemplate.scanAll(Book.class)
                .items()
                .stream()
                .toList();
    }

    public Book save(Book book) {
        book.setCreatedAt(LocalDate.now());
        book.setUpdatedAt(LocalDate.now());
        return dynamoDbTemplate.save(book);
    }

    public Book updateBook(Book book) {
        book.setUpdatedAt(LocalDate.now());
        return dynamoDbTemplate.update(book);
    }

    public Book getBookByISBN(String isbn) {
        return dynamoDbTemplate.load(Key.builder().partitionValue(isbn).build(), Book.class);
    }

    public Book deleteBookByISBN(String isbn) {
       return dynamoDbTemplate.delete(Key.builder().partitionValue(isbn).build(), Book.class);
    }
}
