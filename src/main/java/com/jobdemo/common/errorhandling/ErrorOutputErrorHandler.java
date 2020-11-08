package com.jobdemo.common.errorhandling;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Tomasz Bialecki
 */
public interface ErrorOutputErrorHandler {

    default ResponseEntity<ErrorOutput> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        final String message = Optional.ofNullable(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new ErrorOutput(message, httpStatus.value()), httpStatus);
    }

    default ResponseEntity<ErrorOutput> error(final Exception exception, final HttpStatus httpStatus) {
        final String message = Optional.ofNullable(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new ErrorOutput(message, httpStatus.value()), httpStatus);
    }

    default ResponseEntity<ErrorOutput> error(final String message, final HttpStatus httpStatus) {
        return new ResponseEntity<>(new ErrorOutput(message, httpStatus.value()), httpStatus);
    }
}
