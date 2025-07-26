package com.bookstore.books.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String ISBN;
    private String title;
    private List<String> authors;
    private String publishedDate;
    private List<String> genres;
    private String synopsis;
}
