package com.school.registration.controller;

import com.school.registration.constant.AppConstant;
import com.school.registration.model.Course;
import com.school.registration.model.CourseStudents;
import com.school.registration.model.Student;
import com.school.registration.service.CourseStudentsService;
import com.school.registration.service.dto.CourseStudentsDTO;
import com.school.registration.service.dto.responses.CollectionSuccessResponse;
import com.school.registration.service.dto.responses.SingleSuccessResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@ApiOperation(value = "CRUD operations for course students.")
@RequestMapping(value = "/api/" + AppConstant.API_VERSION + "/courseStudents", produces = "application/json")
public class CourseStudentsController {

    private final CourseStudentsService courseStudentsService;

    @ApiOperation(value = "Fetch Course Students List")
    @GetMapping
    public ResponseEntity<CollectionSuccessResponse<CourseStudents>> findAll() {
        return ResponseEntity.ok().body(new CollectionSuccessResponse<>(AppConstant.COURSE_STUDENT_FETCH_SUCCESS,
                HttpStatus.OK.value(), courseStudentsService.findAll()));
    }

    @ApiOperation(value = "Get Course Students By Id")
    @GetMapping(value = "{id}")
    public ResponseEntity<SingleSuccessResponse<CourseStudents>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new SingleSuccessResponse<>(AppConstant.COURSE_STUDENT_FETCH_SUCCESS,
                HttpStatus.OK.value(), courseStudentsService.findById(id)));
    }

    @ApiOperation(value = "Save Course Students")
    @PostMapping
    public ResponseEntity<SingleSuccessResponse<CourseStudents>> save(@RequestBody CourseStudentsDTO courseStudentsDTO) throws URISyntaxException {
        return ResponseEntity.created(new URI("/api/v1/courses")).body(new SingleSuccessResponse<>(AppConstant.COURSE_STUDENT_SAVE_SUCCESS,
                HttpStatus.CREATED.value(), courseStudentsService.save(courseStudentsDTO)));
    }

    @ApiOperation(value = "Update Course Students")
    @PatchMapping(value = "{id}")
    public ResponseEntity<SingleSuccessResponse<CourseStudents>> update(@PathVariable Long id, @RequestBody CourseStudentsDTO courseStudentsDTO) throws URISyntaxException {

        return ResponseEntity.accepted().body(new SingleSuccessResponse<>(AppConstant.COURSE_STUDENT_UPDATE_SUCCESS,
                HttpStatus.ACCEPTED.value(), courseStudentsService.update(id, courseStudentsDTO)));
    }

    @ApiOperation(value = "Delete Course Students By Id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseStudentsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete Course Students By Course Id")
    @DeleteMapping(value = "/course/{courseId}")
    public ResponseEntity<Void> deleteByCourseId(@PathVariable Long id) {
        courseStudentsService.deleteByCourseId(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete Course Students By Students Id")
    @DeleteMapping(value = "/student/{courseId}")
    public ResponseEntity<Void> deleteByStudentId(@PathVariable Long id) {
        courseStudentsService.deleteByStudentId(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Students Without Any Course")
    @GetMapping(value = "/student/without-course")
    public ResponseEntity<CollectionSuccessResponse<Student>> getStudentsWithoutAnyCourse() {
        return ResponseEntity.ok().body(new CollectionSuccessResponse<>(AppConstant.COURSE_STUDENT_FETCH_SUCCESS,
                HttpStatus.OK.value(), courseStudentsService.getAllStudentsWithoutAnyCourse()));
    }

    @ApiOperation(value = "Courses Without Any Student")
    @GetMapping(value = "/course/without-students")
    public ResponseEntity<CollectionSuccessResponse<Course>> getAllCoursesWithoutAnyStudent() {
        return ResponseEntity.ok().body(new CollectionSuccessResponse<>(AppConstant.COURSE_STUDENT_FETCH_SUCCESS,
                HttpStatus.OK.value(), courseStudentsService.getAllCoursesWithoutAnyStudent()));
    }
}
