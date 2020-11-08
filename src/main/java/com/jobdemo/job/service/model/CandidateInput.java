package com.jobdemo.job.service.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CandidateInput {

    @NotEmpty
    private String name;

    @Min(0)
    private Long experience;
}
