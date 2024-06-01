package com.example.crio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.crio.entity.Exams;
import com.example.crio.entity.Students;
import com.example.crio.entity.SubjectEnrolledStudents;
import com.example.crio.entity.Subjects;
import com.example.crio.repository.ExamRepository;
import com.example.crio.repository.StudentRepository;
import com.example.crio.repository.SubjectEnrolledStudentsRepository;
import com.example.crio.repository.SubjectRepository;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.ArrayList;

@Component
public class DbInit {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final ExamRepository examRepository;
    private final SubjectEnrolledStudentsRepository subjectEnrolledStudentsRepository;

    public DbInit(StudentRepository studentRepository, SubjectRepository subjectRepository,
            ExamRepository examRepository, SubjectEnrolledStudentsRepository subjectEnrolledStudentsRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.examRepository = examRepository;
        this.subjectEnrolledStudentsRepository = subjectEnrolledStudentsRepository;
    }

    @PostConstruct
    public void initializeDatabase() {
        insertSubjects();
        insertExams();
        insertStudents();
        insertSubjectEnrolledStudents();
    }

    private void insertSubjects() {
        List<Subjects> subjects = new ArrayList<>();

        subjects.add(new Subjects(0, "Maths"));
        subjects.add(new Subjects(0, "Social"));
        subjects.add(new Subjects(0, "Science"));

        this.subjectRepository.saveAll(subjects);
    }

    private void insertExams() {
        List<Exams> exams = new ArrayList<>();

        exams.add(new Exams(0, 1));
        exams.add(new Exams(0, 2));
        exams.add(new Exams(0, 3));

        this.examRepository.saveAll(exams);
    }

    private void insertStudents() {
        List<Students> students = new ArrayList<>();

        students.add(new Students(0, "john doe"));
        students.add(new Students(0, "micheal claus"));
        students.add(new Students(0, "damon salvatore"));
        students.add(new Students(0, "stephan salvatore"));

        this.studentRepository.saveAll(students);
    }

    private void insertSubjectEnrolledStudents() {

        List<SubjectEnrolledStudents> subjectEnrollments = new ArrayList<>();

        subjectEnrollments.add(new SubjectEnrolledStudents(0, this.studentRepository.findByName("john doe"),
                this.subjectRepository.findBySubjectName("Maths")));
        subjectEnrollments.add(new SubjectEnrolledStudents(0, this.studentRepository.findByName("damon salvatore"),
                this.subjectRepository.findBySubjectName("Social")));
        subjectEnrollments.add(new SubjectEnrolledStudents(0, this.studentRepository.findByName("micheal claus"),
                this.subjectRepository.findBySubjectName("Science")));
        subjectEnrollments.add(new SubjectEnrolledStudents(0, this.studentRepository.findByName("stephan salvatore"),
                this.subjectRepository.findBySubjectName("Maths")));

        this.subjectEnrolledStudentsRepository.saveAll(subjectEnrollments);

    }

}
