package com.school.registration.service;

import com.school.registration.model.Course;
import com.school.registration.model.CourseStudents;
import com.school.registration.model.Student;
import com.school.registration.service.dto.CourseStudentsDTO;

import java.util.List;

public interface CourseStudentsService {

    CourseStudents save(CourseStudentsDTO courseStudentsDTO);

    CourseStudents update(Long id, CourseStudentsDTO CourseStudentsDTO);

    CourseStudents findById(Long id);

    List<CourseStudents> findAll();

    List<CourseStudents> findAllByCourseId(Long courseId);

    List<CourseStudents> findAllByStudentId(Long studentId);

    List<CourseStudents> findAllByCourseIdStudentId(Long courseId, Long studentId);

    void deleteById(Long id);

    void deleteByCourseId(Long courseId);

    void deleteByStudentId(Long studentId);

    List<Student> getAllStudentsWithoutAnyCourse();

    List<Course> getAllCoursesWithoutAnyStudent();
}
