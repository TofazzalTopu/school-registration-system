package com.school.registration.repository;

import com.school.registration.model.CourseStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseStudentsRepository extends JpaRepository<CourseStudents, Long> {
    List<CourseStudents> findAllByCourseId(Long courseId);

    List<CourseStudents> findAllByStudentId(Long studentId);

    List<CourseStudents> findAllByCourseIdAndStudentId(Long courseId, Long studentId);

    void deleteAllByCourseId(Long courseId);

    void deleteAllByStudentId(Long courseId);
}
