package com.jobdemo.common.errorhandling;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Tomasz Bialecki
 */
@ControllerAdvice
public class EntityNotFountErrorHandler implements ErrorOutputErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorOutput> entityNotFoundException(final EntityNotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND);
    }
}
