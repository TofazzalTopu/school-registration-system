package com.school.registration.service.impl;

import com.school.registration.constant.AppConstant;
import com.school.registration.exceptions.NotFoundException;
import com.school.registration.model.Course;
import com.school.registration.model.CourseStudents;
import com.school.registration.model.Student;
import com.school.registration.repository.CourseStudentsRepository;
import com.school.registration.service.CourseService;
import com.school.registration.service.CourseStudentsService;
import com.school.registration.service.StudentService;
import com.school.registration.service.dto.CourseStudentsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Md Tofazzal Hossain
 * @created on 27/01/2022
 */

@Service
@RequiredArgsConstructor
public class CourseStudentsServiceImpl implements CourseStudentsService {

    private final CourseStudentsRepository courseStudentsRepository;
    private final CourseService courseService;
    private final StudentService studentService;

    @Override
    public CourseStudents save(CourseStudentsDTO courseStudentsDTO) {
        validate(courseStudentsDTO);
        CourseStudents courseStudents = new CourseStudents();
        courseStudents.setCourse(courseService.findById(courseStudentsDTO.getCourseId()));
        courseStudents.setStudent(studentService.findById(courseStudentsDTO.getStudentId()));
        return courseStudentsRepository.save(courseStudents);
    }

    @Override
    public CourseStudents update(Long id, CourseStudentsDTO courseStudentsDTO) {
        validateBeforeUpdate(id, courseStudentsDTO);
        CourseStudents courseStudents = findById(id);
        courseStudents.setCourse(courseService.findById(courseStudentsDTO.getCourseId()));
        courseStudents.setStudent(studentService.findById(courseStudentsDTO.getStudentId()));
        return courseStudentsRepository.save(courseStudents);
    }

    @Override
    public CourseStudents findById(Long id) {
        return courseStudentsRepository.findById(id).orElseThrow(() -> new NotFoundException(AppConstant.COURSE_STUDENT_NOT_FOUND + id));
    }

    @Override
    public List<CourseStudents> findAll() {
        return courseStudentsRepository.findAll(Sort.by("id").descending());
    }

    @Override
    public List<CourseStudents> findAllByCourseId(Long courseId) {
        return courseStudentsRepository.findAllByCourseId(courseId);
    }

    @Override
    public List<CourseStudents> findAllByStudentId(Long studentId) {
        return courseStudentsRepository.findAllByStudentId(studentId);
    }

    @Override
    public List<CourseStudents> findAllByCourseIdStudentId(Long courseId, Long studentId) {
        return courseStudentsRepository.findAllByCourseIdAndStudentId(courseId, studentId);
    }

    @Override
    public void deleteById(Long id) {
        courseStudentsRepository.deleteById(id);
    }

    @Override
    public void deleteByCourseId(Long courseId) {
        courseStudentsRepository.deleteAllByCourseId(courseId);
    }

    @Override
    public void deleteByStudentId(Long studentId) {
        courseStudentsRepository.deleteAllByStudentId(studentId);
    }

    @Override
    public List<Student> getAllStudentsWithoutAnyCourse() {
        List<Student> studentList = studentService.findAll();
        List<Student> studentListWithoutAnyCourse = new ArrayList<>();
        List<CourseStudents> courseStudentsList = findAll();
        studentList.stream().forEach(student -> {
            boolean noneMatch = courseStudentsList.stream().noneMatch(courseStudents -> courseStudents.getStudent().equals(student));
            if (noneMatch) studentListWithoutAnyCourse.add(student);
        });
        return studentListWithoutAnyCourse;
    }

    @Override
    public List<Course> getAllCoursesWithoutAnyStudent() {
        List<Course> courseList = courseService.findAll();
        List<Course> courseListWithoutAnyStudent = new ArrayList<>();
        List<CourseStudents> courseStudentsList = findAll();
        courseList.stream().forEach(course -> {
            boolean noneMatch = courseStudentsList.stream().noneMatch(courseStudents -> courseStudents.getCourse().equals(course));
            if (noneMatch) courseListWithoutAnyStudent.add(course);
        });
        return courseListWithoutAnyStudent;
    }

    private void validate(CourseStudentsDTO courseStudentsDTO) {
        List<CourseStudents> courseStudentsList = findAllByCourseIdStudentId(courseStudentsDTO.getCourseId(), courseStudentsDTO.getStudentId());
        if (!courseStudentsList.isEmpty()) {
            throw Problem.builder().withTitle(Status.NOT_ACCEPTABLE.name()).withStatus(Status.NOT_ACCEPTABLE)
                    .withDetail(AppConstant.COURSE_ALREADY_EXIST_FOR_THE_STUDENT).build();
        }

        List<CourseStudents> courseStudentsListByCourseId = findAllByCourseId(courseStudentsDTO.getCourseId());
        if (courseStudentsListByCourseId.size() == 50) {
            throw Problem.builder().withTitle(Status.NOT_ACCEPTABLE.name()).withStatus(Status.NOT_ACCEPTABLE)
                    .withDetail(AppConstant.ONE_COURSE_COULD_NOT_REGISTER_MORE_THAN_FIFTY_STUDENTS).build();
        }

        List<CourseStudents> courseStudentsListByStudentId = findAllByStudentId(courseStudentsDTO.getStudentId());
        if (courseStudentsListByStudentId.size() == 5) {
            throw Problem.builder().withTitle(Status.NOT_ACCEPTABLE.name()).withStatus(Status.NOT_ACCEPTABLE)
                    .withDetail(AppConstant.ONE_STUDENT_COULD_NOT_REGISTER_MORE_THAN_FIVE_COURSES).build();
        }
    }

    private void validateBeforeUpdate(Long courseStudentId, CourseStudentsDTO courseStudentsDTO) {
        Course course = courseService.findById(courseStudentsDTO.getCourseId());
        Student student = studentService.findById(courseStudentsDTO.getStudentId());

        List<CourseStudents> courseStudentsList = findAllByCourseIdStudentId(courseStudentsDTO.getCourseId(), courseStudentsDTO.getStudentId());
        if (!courseStudentsList.isEmpty() && !courseStudentsList.get(0).getId().equals(courseStudentId)) {
            throw Problem.builder().withTitle(Status.NOT_ACCEPTABLE.name()).withStatus(Status.NOT_ACCEPTABLE)
                    .withDetail(AppConstant.COURSE_ALREADY_EXIST_FOR_THE_STUDENT).build();
        }
    }

}
