package com.example.crio.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.crio.exceptions.InvalidExamException;
import com.example.crio.exceptions.InvalidStudentException;

@RestControllerAdvice
public class ExamRegistrationExceptionHandler {

    @ExceptionHandler
    public String handleInvalidExamIdException(InvalidExamException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler
    public String handleInvalidStudentException(InvalidStudentException exception) {
        return exception.getMessage();
    }

}
