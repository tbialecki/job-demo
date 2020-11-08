package com.jobdemo.common.errorhandling;

import java.io.Serializable;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class ErrorOutput implements Serializable {

    private static final long serialVersionUID = 6809430691417060679L;
    private final String message;
    private final String status = "error";
    private final Date timestamp;
    private final int httpStatus;

    public ErrorOutput(String message, int httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = new Date(System.currentTimeMillis());
    }
}
