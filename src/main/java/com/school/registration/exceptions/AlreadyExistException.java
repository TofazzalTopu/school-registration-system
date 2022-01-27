package com.school.registration.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

/**
 * @author Md Tofazzal Hossain
 * @created on 27/01/2022
 */

public class AlreadyExistException extends AbstractThrowableProblem {

    private static final URI TYPE
            = URI.create("https://locahost");

    public AlreadyExistException(String message) {
        super(
                TYPE,
                Status.NOT_ACCEPTABLE.name(),
                Status.NOT_ACCEPTABLE,
                message);
    }
}
