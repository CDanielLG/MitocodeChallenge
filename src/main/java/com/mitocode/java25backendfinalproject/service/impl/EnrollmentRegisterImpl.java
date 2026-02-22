package com.mitocode.java25backendfinalproject.service.impl;


import com.mitocode.java25backendfinalproject.exception.ModelNotFoundException;
import com.mitocode.java25backendfinalproject.model.EnrollmentDetail;
import com.mitocode.java25backendfinalproject.model.EnrollmentRegister;
import com.mitocode.java25backendfinalproject.repo.ICourseRepo;
import com.mitocode.java25backendfinalproject.repo.IEnrollmentRegisterRepo;
import com.mitocode.java25backendfinalproject.repo.IGenericRepo;
import com.mitocode.java25backendfinalproject.repo.IStudentRepo;
import com.mitocode.java25backendfinalproject.service.IEnrollmentRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentRegisterImpl extends CRUDImpl<EnrollmentRegister, Integer> implements IEnrollmentRegisterService {

    private final IEnrollmentRegisterRepo repo;
    private final IStudentRepo studentRepo;
    private final ICourseRepo courseRepo;

    @Override
    protected IGenericRepo<EnrollmentRegister, Integer> getRepo() {
        return repo;
    }

    @Override
    public EnrollmentRegister save(EnrollmentRegister t) throws Exception {
        t.getEnrollmentDetail().forEach(detail -> detail.setEnrollmentRegister(t));

        return repo.save(t);
    }

    @Override
    public EnrollmentRegister update(Integer id, EnrollmentRegister t) throws Exception {
        t.getEnrollmentDetail().forEach(detail -> detail.setEnrollmentRegister(t));
        return super.update(id, t);
    }

    //Obtener los cursos con sus estudiantes inscritos
    public Map<String, List<String>> getCoursesWithStudents() {

        List<EnrollmentRegister> enrollments = repo.findAll();

        return enrollments.stream()
                .flatMap(enrollment -> enrollment.getEnrollmentDetail().stream()
                        .map(detail -> Map.entry(
                                detail.getCourse().getNameOfCourse(),
                                enrollment.getStudent().getName() + " " + enrollment.getStudent().getLastName()
                        ))
                )
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }
}
