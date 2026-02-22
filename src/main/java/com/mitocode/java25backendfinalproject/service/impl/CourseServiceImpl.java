package com.mitocode.java25backendfinalproject.service.impl;

import com.mitocode.java25backendfinalproject.model.Course;
import com.mitocode.java25backendfinalproject.repo.ICourseRepo;
import com.mitocode.java25backendfinalproject.repo.IGenericRepo;
import com.mitocode.java25backendfinalproject.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
}
