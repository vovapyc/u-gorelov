package com.example.demo.controllers;

import com.example.demo.models.ResultModel;
import com.example.demo.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(path = "/{id}/near")
    public @ResponseBody
    Iterable<ResultModel> getUser(@PathVariable Integer id) {
        ResultModel originalCoordinate = resultRepository.findById(id);
        String searchCoordinateCode = originalCoordinate.getResult().substring(0, 20);
        List<ResultModel> nearModels = new ArrayList<>();

        for (ResultModel m : resultRepository.findAll()) {
            if (!m.getId().equals(originalCoordinate.getId()) && m.getResult().substring(0, 20).equals(searchCoordinateCode)) {
                nearModels.add(m);
            }
        }

        return nearModels;
    }
}
