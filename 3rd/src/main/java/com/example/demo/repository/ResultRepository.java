package com.example.demo.repository;

import com.example.demo.models.ResultModel;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<ResultModel, Long> {

    // List<Model> findByLastName(String lastName);

    ResultModel findById(long id);
}
