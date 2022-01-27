package com.school.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull(message = "code can not be null!")
    @Column(name = "course_code", nullable = false, unique = true, length = 10)
    private String code;


    @NotNull(message = "name can not be null!")
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;
}
