package com.mitocode.java25backendfinalproject.controller;

import com.mitocode.java25backendfinalproject.dto.EnrollmentRegisterDTO;
import com.mitocode.java25backendfinalproject.model.EnrollmentRegister;
import com.mitocode.java25backendfinalproject.service.IEnrollmentRegisterService;
import com.mitocode.java25backendfinalproject.service.impl.EnrollmentRegisterImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentRegisterController {

    private final IEnrollmentRegisterService service;


    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<EnrollmentRegisterDTO>> findAll() throws Exception {
        List<EnrollmentRegisterDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentRegisterDTO> findById(@PathVariable Integer id) throws Exception {
        EnrollmentRegister obj = service.findById(id);
        return ResponseEntity.ok(this.convertToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<EnrollmentRegisterDTO> save(@Valid @RequestBody EnrollmentRegisterDTO dto) throws Exception {
        EnrollmentRegister obj = service.save(convertToEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentRegisterDTO> update(@Valid @RequestBody EnrollmentRegisterDTO dto, @PathVariable Integer id) throws Exception {
        EnrollmentRegister obj = service.update(id, convertToEntity(dto));
        return ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/courses-with-students")
    public ResponseEntity<Map<String, List<String>>> getCoursesWithStudents() throws Exception {
        Map<String, List<String>> result = service.getCoursesWithStudents();
        return ResponseEntity.ok(result);
    }

    private EnrollmentRegisterDTO convertToDTO(EnrollmentRegister entity) {
        return modelMapper.map(entity, EnrollmentRegisterDTO.class);
    }

    private EnrollmentRegister convertToEntity(EnrollmentRegisterDTO dto) {
        return modelMapper.map(dto, EnrollmentRegister.class);
    }
}
