package com.mitocode.java25backendfinalproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mitocode.java25backendfinalproject.dto.EnrollmentDetailDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EnrollmentRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollmentRegister;

    @Column(nullable = false)
    private LocalDateTime enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name = "fk_student_enrollment_register"))
    private Student student;

    @Column(nullable = false)
    private  Boolean status;

    @OneToMany(mappedBy = "enrollmentRegister", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnrollmentDetail> enrollmentDetail;



}
