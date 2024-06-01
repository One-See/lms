package com.example.crio.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<SubjectEnrolledStudents> enrolledSubjects;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<ExamEnrolledStudents> enrolledExams;

    public Students(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
