package com.example.crio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.crio.entity.Exams;

@RepositoryRestResource(path = "exams")
public interface ExamRepository extends CrudRepository<Exams, Integer> {

}
