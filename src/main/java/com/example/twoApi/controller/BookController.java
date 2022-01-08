package com.example.twoApi.controller;

import com.example.twoApi.exception_handling.NoSuchBookException;
import com.example.twoApi.models.Book;
import com.example.twoApi.service.DefaultBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/books")
public class BookController {

    @Autowired
    private DefaultBookService bookService;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            throw new NoSuchBookException("Бро, тут такое дело, книги с таким айди = " + id + " не нашлось в базе...");
        }
        return book;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Бро, все четко!!! :)");
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }

    @PutMapping
    public ResponseEntity updateBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Бро, изменения сохранены! Все четко!!! :)");
    }

}
