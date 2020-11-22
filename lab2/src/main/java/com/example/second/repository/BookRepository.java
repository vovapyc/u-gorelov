package com.example.second.repository;

import com.example.second.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findById(long id);
}