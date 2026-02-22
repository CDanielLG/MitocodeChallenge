package com.mitocode.java25backendfinalproject.service;

import com.mitocode.java25backendfinalproject.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer>{
    public List<Student> getStudentsSortedByAgeDesc() throws Exception;
}
