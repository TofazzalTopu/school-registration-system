package com.school.registration.controller;


import com.school.registration.constant.AppConstant;
import com.school.registration.model.Student;
import com.school.registration.service.StudentService;
import com.school.registration.service.dto.responses.CollectionSuccessResponse;
import com.school.registration.service.dto.responses.SingleSuccessResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@ApiOperation(value = "CRUD operations for student.")
@RequestMapping(value = "/api/" + AppConstant.API_VERSION + "/students", produces = "application/json")
public class StudentController {

    private final StudentService studentService;

    @ApiOperation(value = "Fetch Student List")
    @GetMapping
    public ResponseEntity<CollectionSuccessResponse<Student>> findAll() {
        return ResponseEntity.ok().body(new CollectionSuccessResponse<>(AppConstant.STUDENT_FETCH_SUCCESS,
                HttpStatus.OK.value(), studentService.findAll()));
    }

    @ApiOperation(value = "Get Student By Id")
    @GetMapping(value = "{id}")
    public ResponseEntity<SingleSuccessResponse<Student>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new SingleSuccessResponse<>(AppConstant.STUDENT_FETCH_SUCCESS,
                HttpStatus.OK.value(), studentService.findById(id)));
    }

    @ApiOperation(value = "Save Student")
    @PostMapping
    public ResponseEntity<SingleSuccessResponse<Student>> save(@RequestBody Student student) throws URISyntaxException {
        if (studentService.findByCode(student.getCode()).isPresent()) {
            return ResponseEntity.badRequest().body(new SingleSuccessResponse<>(AppConstant.STUDENT_CODE_ALREADY_EXIST + student.getCode(),
                    HttpStatus.BAD_REQUEST.value(), null));
        }
        return ResponseEntity.created(new URI("api/v1/students")).body(new SingleSuccessResponse<>(AppConstant.STUDENT_SAVE_SUCCESS,
                HttpStatus.CREATED.value(), studentService.save(student)));
    }

    @ApiOperation(value = "Update Student")
    @PatchMapping(value = "{id}")
    public ResponseEntity<SingleSuccessResponse<Student>> update(@PathVariable Long id, @RequestBody Student student) throws URISyntaxException {
        Optional<Student> existingStudent = studentService.findByCode(student.getCode());

        if (existingStudent.isPresent() && !existingStudent.get().getId().equals(id)) {
            return ResponseEntity.badRequest().body(new SingleSuccessResponse<>(AppConstant.STUDENT_CODE_ALREADY_EXIST + student.getCode(),
                    HttpStatus.BAD_REQUEST.value(), null));
        }
        return ResponseEntity.accepted().body(new SingleSuccessResponse<>(AppConstant.STUDENT_UPDATE_SUCCESS,
                HttpStatus.ACCEPTED.value(), studentService.update(id, student)));
    }

    @ApiOperation(value = "Delete Student By Id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
