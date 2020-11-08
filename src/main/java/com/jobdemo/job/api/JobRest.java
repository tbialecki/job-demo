package com.jobdemo.job.api;


import com.jobdemo.job.service.JobService;
import com.jobdemo.job.service.model.CandidateTo;
import com.jobdemo.job.service.model.JobInput;
import com.jobdemo.job.service.model.JobTo;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
@AllArgsConstructor
public class JobRest {

    private final JobService jobService;

    @GetMapping
    public List<JobTo> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PutMapping
    @PreAuthorize("hasRole('USER')")
    public JobTo createJob(@RequestBody @Valid JobInput job, Authentication a) {
        return jobService.createJob(job);
    }

    @PostMapping("{id}/candidate/{candidateId}")
    @PreAuthorize("hasRole('USER')")
    public void createJob(@PathVariable("id") Long jobId, @PathVariable("candidateId") Long candidateId) {
        jobService.assignCandidate(jobId, candidateId);
    }

    @GetMapping("{id}/candidate")
    @PreAuthorize("hasRole('USER')")
    public List<CandidateTo> createJob(@PathVariable("id") Long jobId) {
        return jobService.jobCandidates(jobId);
    }
}



