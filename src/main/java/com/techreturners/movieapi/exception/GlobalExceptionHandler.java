package com.techreturners.movieapi.exception;


import com.techreturners.movieapi.controller.web.ApiError;
import com.techreturners.movieapi.controller.web.ResponseEntityBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // handleResourceNotFoundException : triggers when there is no resource with the specified ID.

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                "Resource Not Found",
                details);

        return ResponseEntityBuilder.build(err);
    }

    @ExceptionHandler(ResourceSaveFailedException.class)
    public ResponseEntity<Object> handleResourceSaveFailedException(ResourceSaveFailedException ex) {

        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());

        ApiError err = new ApiError(
                LocalDateTime.now(),
                HttpStatus.CONFLICT,
                "Resource Already Exists",
                details);

        return ResponseEntityBuilder.build(err);
    }
}