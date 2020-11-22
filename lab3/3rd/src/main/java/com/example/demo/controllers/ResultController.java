package com.example.demo.controllers;

import com.example.demo.models.ResultModel;
import com.example.demo.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/results")
public class ResultController {
    @Autowired
    private ResultRepository resultRepository;

    @GetMapping(path = "")
    public @ResponseBody
    Iterable<ResultModel> getAllUsers() {
        return resultRepository.findAll();
    }
}
