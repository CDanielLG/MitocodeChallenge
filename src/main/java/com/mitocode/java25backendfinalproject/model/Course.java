package com.mitocode.java25backendfinalproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCourse;

    @Column(nullable = false, length = 50)
    private String nameOfCourse;

    @Column(nullable = false, length = 50)
    private String initialisms;

    @Column(nullable = false, length = 50)
    private boolean state;
}
