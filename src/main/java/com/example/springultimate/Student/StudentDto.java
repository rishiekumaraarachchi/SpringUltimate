package com.example.springultimate.Student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "First name is required")
        String firstname,
        String lastname,
        @NotEmpty (message = "Email is required")
        String email,
        Integer schoolId) {

}
