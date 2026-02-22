package com.mitocode.java25backendfinalproject.controller;

import com.mitocode.java25backendfinalproject.dto.StudentDTO;
import com.mitocode.java25backendfinalproject.model.Student;
import com.mitocode.java25backendfinalproject.service.IStudentService;
import com.mitocode.java25backendfinalproject.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() throws Exception{
    List<StudentDTO> list = service.findAll().stream().map(this::convertToDTO).toList();
    return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) throws Exception{
        Student obj = service.findById(id);

        return ResponseEntity.ok(this.convertToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.save(convertToEntity(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO dto, @PathVariable Integer id) throws Exception{
        Student obj = service.update(id, convertToEntity(dto));

        return ResponseEntity.ok(this.convertToDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/age/sorted-desc")
    public ResponseEntity<List<StudentDTO>> getStudentsSortedByAgeDesc() throws Exception {
        List<StudentDTO> list = service.getStudentsSortedByAgeDesc()
                .stream()
                .map(this::convertToDTO)
                .toList();
        return ResponseEntity.ok(list);
    }

    private StudentDTO convertToDTO(Student entity) {
        return modelMapper.map(entity, StudentDTO.class);
    }

    private Student convertToEntity(StudentDTO dto) {
        return modelMapper.map(dto, Student.class);
    }

}
