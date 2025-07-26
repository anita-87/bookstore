package com.bookstore.books.services;

import com.bookstore.books.dtos.BookDto;

import java.util.List;

public interface BooksService {

    List<BookDto> getAllBooks();
    BookDto getBookByISBN(String isbn);
    BookDto save(BookDto book);
    BookDto updateBook(String isbn, BookDto book);
    BookDto deleteBookByISBN(String isbn);
}
