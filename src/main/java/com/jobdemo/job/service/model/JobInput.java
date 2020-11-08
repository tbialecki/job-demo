package com.jobdemo.job.service.model;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class JobInput {

    @NotEmpty
    private String jobName;

    @NotEmpty
    private String description;

    @NotEmpty
    private String location;
}
