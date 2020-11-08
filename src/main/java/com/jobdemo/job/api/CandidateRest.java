package com.jobdemo.job.api;


import com.jobdemo.job.service.JobService;
import com.jobdemo.job.service.model.CandidateInput;
import com.jobdemo.job.service.model.CandidateTo;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
@AllArgsConstructor
public class CandidateRest {

    private final JobService jobService;

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public CandidateTo createCandidate(@RequestBody @Valid CandidateInput input) {
        return jobService.createCandidate(input);
    }
}



