package com.mitocode.java25backendfinalproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    @Size(min = 3, max = 50)
    private String nameOfCourse;

    @NotNull
    @Size(min = 1, max = 50)
    private String initialisms;

    @NotNull
    private Boolean state;
}
