package com.school.registration.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Md Tofazzal Hossain
 * @created on 27/01/2022
 */

@Data
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
