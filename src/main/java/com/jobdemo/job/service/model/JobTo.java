package com.jobdemo.job.service.model;

import lombok.Data;

@Data
public class JobTo {

    private Long id;
    private String jobName;
    private String description;
    private String location;
}
