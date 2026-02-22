package com.mitocode.java25backendfinalproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentRegisterDTO {

    private Integer idEnrollmentRegister;

    @NotNull
    private LocalDateTime enrollmentDate;

    @NotNull
    private StudentDTO student;



    @JsonManagedReference // Para manejar la referencia bidireccional en JSON
    private List<EnrollmentDetailDTO> enrollmentDetail;

    @NotNull
    private Boolean status;
}
