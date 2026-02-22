package com.mitocode.java25backendfinalproject.config;

import com.mitocode.java25backendfinalproject.dto.CourseDTO;
import com.mitocode.java25backendfinalproject.model.Course;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {


    @Bean("defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean("categoryMapper")
    public ModelMapper categoryMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //Handle Mismatches

        //LECTURA
        modelMapper.createTypeMap(Course.class, CourseDTO.class)
                .addMapping(Course::getNameOfCourse, CourseDTO::setNameOfCourse);

        //ESCRITURA
        modelMapper.createTypeMap(CourseDTO.class, Course.class)
                .addMapping(CourseDTO::getNameOfCourse, Course::setNameOfCourse);


        return modelMapper;
    }
}
