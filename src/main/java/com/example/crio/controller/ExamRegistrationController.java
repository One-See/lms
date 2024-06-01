package com.example.crio.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crio.dto.StudentRegistrationDTO;
import com.example.crio.exceptions.InvalidExamException;
import com.example.crio.exceptions.InvalidStudentException;
import com.example.crio.service.ExamRegistrationService;

import jakarta.validation.Valid;

@RestController
public class ExamRegistrationController {

    private final ExamRegistrationService examRegistrationService;

    public ExamRegistrationController(ExamRegistrationService examRegistrationService) {
        this.examRegistrationService = examRegistrationService;
    }

    @PostMapping(path = "/exam")
    public String registerStudendForExam(@RequestParam(required = true) int examId,
            @Valid @RequestBody StudentRegistrationDTO studentRegistrationDTO)
            throws InvalidExamException, InvalidStudentException {

        return this.examRegistrationService.registerStudendForExam(examId, studentRegistrationDTO.getStudentId());

    }

}
