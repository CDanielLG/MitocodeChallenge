package com.mitocode.java25backendfinalproject.service.impl;

import com.mitocode.java25backendfinalproject.model.Student;
import com.mitocode.java25backendfinalproject.repo.IGenericRepo;
import com.mitocode.java25backendfinalproject.repo.IStudentRepo;
import com.mitocode.java25backendfinalproject.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student,Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
     }

    // Método para obtener estudiantes ordenados por edad descendente
    public List<Student> getStudentsSortedByAgeDesc() throws Exception {
        return repo.findAll().stream()
                .sorted((s1, s2) -> s2.getAge().compareTo(s1.getAge()))
                .toList();
    }
}
