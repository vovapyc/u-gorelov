package com.example.second.controllers;

import com.example.second.models.Book;
import com.example.second.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/books")
public class BookController {
    @Autowired
    private BookRepository userRepository;

    @PostMapping(path = "/")
    public @ResponseBody
    String addNewBook(@RequestBody Book book) {
        userRepository.save(book);
        return "Saved";
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<Book> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    String deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "Ok";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Optional<Book> getUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    String updateUser(@PathVariable Integer id, @RequestBody Book book) {
        Optional<Book> b = userRepository.findById(id);

        b.get().setAuthor(book.getAuthor());
        b.get().setEdition(book.getEdition());
        b.get().setName(book.getName());
        b.get().setPageCount(book.getPageCount());
        b.get().setPublication(book.getPublication());

        userRepository.save(b.get());
        return "Ok";
    }
}
