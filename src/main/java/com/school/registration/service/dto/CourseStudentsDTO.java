package com.school.registration.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentsDTO extends BaseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long studentId;

    private Long courseId;
}
