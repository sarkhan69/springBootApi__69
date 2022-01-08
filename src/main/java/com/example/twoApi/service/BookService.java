package com.example.twoApi.service;

import com.example.twoApi.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book getBookById(Long id);

    List<Book> getAllBooks();

    void addBook(Book book);

    void deleteBookById(Long id);
}
