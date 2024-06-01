package com.example.crio.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRegistrationDTO {

    @NotNull(message = "Please provide a unique studentId")
    private int studentId;

}
