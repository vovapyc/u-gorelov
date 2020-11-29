package com.example.demo.controllers;


import com.example.demo.Parser;
import com.example.demo.repository.ResultRepository;
import com.example.demo.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

    private final StorageService storageService;
    private final ResultRepository resultRepository;

    @Autowired
    public FileUploadController(StorageService storageService, ResultRepository resultRepository) {
        this.storageService = storageService;
        this.resultRepository = resultRepository;
    }

    @GetMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        Parser p = new Parser();
        p.writeCoordinates(storageService.load(file.getOriginalFilename()).toFile(), resultRepository);

        return "redirect:/results";
    }
}