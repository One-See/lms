package com.example.crio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.crio.entity.ExamEnrolledStudents;

@RepositoryRestResource
public interface ExamEnrolledStudentsRepository extends CrudRepository<ExamEnrolledStudents, Integer> {

}
