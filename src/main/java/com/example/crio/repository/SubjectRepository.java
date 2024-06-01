package com.example.crio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.crio.entity.Subjects;

@RepositoryRestResource(path = "subjects")
public interface SubjectRepository extends CrudRepository<Subjects, Integer> {

    public Subjects findBySubjectName(String subjectName);

}
