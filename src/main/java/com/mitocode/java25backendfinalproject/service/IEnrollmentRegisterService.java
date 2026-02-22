package com.mitocode.java25backendfinalproject.service;

import com.mitocode.java25backendfinalproject.model.EnrollmentRegister;

import java.util.List;
import java.util.Map;

public interface IEnrollmentRegisterService extends ICRUD<EnrollmentRegister, Integer>{
    public Map<String, List<String>> getCoursesWithStudents();
}
