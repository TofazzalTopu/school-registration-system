package com.school.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_students")
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseStudents extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Student can not be null!")
    @ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @NotNull(message = "Course can not be null!")
    @ManyToOne(targetEntity = Course.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
