package com.example.second.controllers;

import com.example.second.repository.BookRepository;
import com.example.second.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(path = "/demo")
public class BookController {
    @Autowired
    private BookRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewBook(@RequestBody Book book) {
        userRepository.save(book);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Book> getAllUsers() {
        return userRepository.findAll();
    }
}
