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
public class Exams {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int subjectId;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<ExamEnrolledStudents> students;

    public Exams(int id, int subjectId) {
        this.id = id;
        this.subjectId = subjectId;
    }

}
