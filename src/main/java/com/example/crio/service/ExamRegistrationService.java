package com.example.crio.service;

import org.springframework.stereotype.Service;

import com.example.crio.entity.ExamEnrolledStudents;
import com.example.crio.entity.Exams;
import com.example.crio.entity.Students;
import com.example.crio.exceptions.InvalidExamException;
import com.example.crio.exceptions.InvalidStudentException;
import com.example.crio.repository.ExamEnrolledStudentsRepository;
import com.example.crio.repository.ExamRepository;
import com.example.crio.repository.StudentRepository;

import java.util.Optional;

@Service
public class ExamRegistrationService {

    private final StudentRepository studentRepository;
    private final ExamRepository examRepository;
    private final ExamEnrolledStudentsRepository examEnrolledStudentsRepository;

    public ExamRegistrationService(ExamEnrolledStudentsRepository examEnrolledStudentsRepository,
            ExamRepository examRepository, StudentRepository studentRepository) {
        this.examEnrolledStudentsRepository = examEnrolledStudentsRepository;
        this.studentRepository = studentRepository;
        this.examRepository = examRepository;
    }

    public String registerStudendForExam(int examId, int studentId)
            throws InvalidExamException, InvalidStudentException {
        // check if exam id exists
        Optional<Exams> exam = this.examRepository.findById(examId);

        if (!exam.isPresent()) {
            throw new InvalidExamException("Exam is not found, please try again");
        }

        // check if student id exists
        Optional<Students> student = this.studentRepository.findById(studentId);

        if (!student.isPresent()) {
            throw new InvalidStudentException("Student is not found, please try again");
        }

        if (exam.isPresent() && student.isPresent()) {
            this.examEnrolledStudentsRepository.save(new ExamEnrolledStudents(0, exam.get(), student.get()));
        }

        return "registered successfully";

    }

}
