package com.example.twoApi.service;

import com.example.twoApi.dao.BookRepository;
import com.example.twoApi.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultBookService implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book getBookById(Long id) {
        Book book = null;
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }


}
