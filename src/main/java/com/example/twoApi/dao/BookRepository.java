package com.example.twoApi.dao;

import com.example.twoApi.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
