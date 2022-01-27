package com.school.registration.service;

import com.school.registration.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course save(Course course);

    Course update(Long id, Course course);

    Course findById(Long id);

    Optional<Course> findByCode(String code);

    Optional<Course> findByName(String code);

    List<Course> findAll();

    void deleteById(Long id);
}
