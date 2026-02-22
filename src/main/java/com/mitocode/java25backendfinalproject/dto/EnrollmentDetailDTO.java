package com.mitocode.java25backendfinalproject.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mitocode.java25backendfinalproject.model.EnrollmentRegister;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDetailDTO {

    @JsonBackReference // Para manejar la referencia bidireccional en JSON
    private EnrollmentRegisterDTO enrollmentRegister;

    @NotNull
    private CourseDTO course;

    @NotNull
    @Size(min = 3, max = 50)
    private String classroom;
}
