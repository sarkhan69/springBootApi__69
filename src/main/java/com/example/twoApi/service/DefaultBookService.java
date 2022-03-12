package com.example.twoApi.service;

import com.example.twoApi.dao.BookRepository;
import com.example.twoApi.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DefaultBookService implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Optional<Book> getBookById(Long id) {
        log.info("Поиск записи с id = {}", id);
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        log.info("Поиск всех записей в таблице books");
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        log.info("Запись в базу {}", book);
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        log.info("Удаление записи с id = {}", id);
        bookRepository.deleteById(id);
    }
}
