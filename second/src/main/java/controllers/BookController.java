package controllers;
import Repository.BookRepository;
import models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(path="/demo")
public class   BookController {
    @Autowired
    private BookRepository userRepository;
    @PostMapping(path="/add")
    public @ResponseBody String addNewBook (@RequestParam String name,
                                            @RequestParam String email,
                                            @RequestBody LocalDate publicationDate,
                                            @RequestBody String edition,
                                            @RequestBody Integer pageCount){
        Book n = new Book();
        n.setName(name);
        n.setAuthor(email);
        n.setPublication(publicationDate);
        n.setEdition(edition);
        n.setPageCount(pageCount);

        userRepository.save(n);
        return "Saved";
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllUsers() {
        return userRepository.findAll();
    }




}
