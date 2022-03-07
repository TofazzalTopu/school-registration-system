package com.school.registration.service.impl;

import com.school.registration.constant.AppConstant;
import com.school.registration.exceptions.AlreadyExistException;
import com.school.registration.exceptions.NotFoundException;
import com.school.registration.model.Course;
import com.school.registration.repository.CourseRepository;
import com.school.registration.service.CourseService;
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
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Course save(Course course) {

        if (findByCode(course.getCode()).isPresent())
            throw new AlreadyExistException(AppConstant.COURSE_CODE_ALREADY_EXIST_FOR_THE_STUDENT + course.getCode());
        if (findByName(course.getName()).isPresent())
            throw new AlreadyExistException(AppConstant.COURSE_NAME_ALREADY_EXIST_FOR_THE_STUDENT + course.getName());

        return courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course course) {
        Course existingCourse = findById(id);
        existingCourse.setCode(course.getCode());
        existingCourse.setName(course.getName());
        return courseRepository.save(existingCourse);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new NotFoundException(AppConstant.COURSE_NOT_FOUND + id));
    }

    @Override
    public Optional<Course> findByCode(String code) {
        return courseRepository.findByCode(code);
    }

    @Override
    public Optional<Course> findByName(String code) {
        return courseRepository.findByName(code);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll(Sort.by("name").ascending());
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
