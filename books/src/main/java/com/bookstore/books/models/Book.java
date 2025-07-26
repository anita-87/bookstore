package com.bookstore.books.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.LocalDate;
import java.util.List;

@DynamoDbBean
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(name = "Books")
public class Book {

    @Getter(onMethod_ =  {@DynamoDbPartitionKey})
    private String ISBN;
    private String title;
    private List<String> authors;
    private String publishedDate;
    private List<String> genres;
    private String synopsis;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
