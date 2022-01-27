package com.school.registration.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

/**
 * @author Md Tofazzal Hossain
 * @created on 27/01/2022
 */

public class NotFoundException extends AbstractThrowableProblem {

    private static final URI TYPE
            = URI.create("https://locahost");

    public NotFoundException(String message) {
        super(
                TYPE,
                Status.NOT_FOUND.name(),
                Status.NOT_FOUND,
                message);
    }
}
