package com.techreturners.movieapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceSaveFailedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceSaveFailedException(String message) {
        super(message);
    }
}