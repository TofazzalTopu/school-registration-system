package com.school.registration.service.impl;

import com.school.registration.constant.AppConstant;
import com.school.registration.exceptions.NotFoundException;
import com.school.registration.model.Student;
import com.school.registration.repository.StudentRepository;
import com.school.registration.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Md Tofazzal Hossain
 * @created on 27/01/2022
 */

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Student existingStudent = findById(id);
        existingStudent.setCode(student.getCode());
        existingStudent.setName(student.getName());
        return studentRepository.save(existingStudent);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new NotFoundException(AppConstant.STUDENT_NOT_FOUND + id));
    }

    @Override
    public Optional<Student> findByCode(String code) {
        return studentRepository.findByCode(code);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll(Sort.by("name").ascending());
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
