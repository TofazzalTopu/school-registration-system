package com.school.registration.service;

import com.school.registration.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);

    Student update(Long id, Student student);

    Student findById(Long id);

    Optional<Student> findByCode(String code);

    List<Student> findAll();

    void deleteById(Long id);
}
