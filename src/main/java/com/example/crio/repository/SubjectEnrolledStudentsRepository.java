package com.example.crio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.crio.entity.SubjectEnrolledStudents;

@RepositoryRestResource
public interface SubjectEnrolledStudentsRepository extends CrudRepository<SubjectEnrolledStudents, Integer> {

}
