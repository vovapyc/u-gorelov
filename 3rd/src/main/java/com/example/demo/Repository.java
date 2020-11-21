package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<ResultModel, Long> {

    // List<Model> findByLastName(String lastName);

    ResultModel findById(long id);
}
