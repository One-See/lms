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
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String subjectName;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<SubjectEnrolledStudents> students;

    public Subjects(int id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

}
