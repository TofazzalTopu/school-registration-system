package com.school.registration.controller;

import com.school.registration.constant.AppConstant;
import com.school.registration.model.Course;
import com.school.registration.service.CourseService;
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
@ApiOperation(value = "CRUD operations for course.")
@RequestMapping(value = "/api/" + AppConstant.API_VERSION + "/courses", produces = "application/json")
public class CourseController {

    private final CourseService courseService;

    @ApiOperation(value = "Fetch Course List")
    @GetMapping
    public ResponseEntity<CollectionSuccessResponse<Course>> findAll() {
        return ResponseEntity.ok().body(new CollectionSuccessResponse<>(AppConstant.COURSE_FETCH_SUCCESS,
                HttpStatus.OK.value(), courseService.findAll()));
    }

    @ApiOperation(value = "Get Course By Id")
    @GetMapping(value = "{id}")
    public ResponseEntity<SingleSuccessResponse<Course>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new SingleSuccessResponse<>(AppConstant.COURSE_FETCH_SUCCESS,
                HttpStatus.OK.value(), courseService.findById(id)));
    }

    @ApiOperation(value = "Save Course")
    @PostMapping
    public ResponseEntity<SingleSuccessResponse<Course>> save(@RequestBody Course course) throws URISyntaxException {
        if (courseService.findByCode(course.getCode()).isPresent()) {
            return ResponseEntity.badRequest().body(new SingleSuccessResponse<>(AppConstant.COURSE_CODE_ALREADY_EXIST + course.getCode(),
                    HttpStatus.BAD_REQUEST.value(), null));
        }
        return ResponseEntity.created(new URI("/api/v1/courses")).body(new SingleSuccessResponse<>(AppConstant.COURSE_SAVE_SUCCESS,
                HttpStatus.CREATED.value(), courseService.save(course)));
    }

    @ApiOperation(value = "Update Course")
    @PatchMapping(value = "{id}")
    public ResponseEntity<SingleSuccessResponse<Course>> update(@PathVariable Long id, @RequestBody Course course) throws URISyntaxException {
        Optional<Course> existingCourse = courseService.findByCode(course.getCode());
        if (existingCourse.isPresent() && !existingCourse.get().getId().equals(id)) {
            return ResponseEntity.badRequest().body(new SingleSuccessResponse<>(AppConstant.COURSE_CODE_ALREADY_EXIST + course.getCode(),
                    HttpStatus.BAD_REQUEST.value(), null));
        }
        return ResponseEntity.accepted().body(new SingleSuccessResponse<>(AppConstant.COURSE_UPDATE_SUCCESS,
                HttpStatus.ACCEPTED.value(), courseService.update(id, course)));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
