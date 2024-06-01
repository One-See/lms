package com.example.crio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.crio.entity.Students;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends CrudRepository<Students, Integer> {

    public Students findByName(String name);

}
