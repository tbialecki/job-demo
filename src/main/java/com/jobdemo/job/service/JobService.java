package com.jobdemo.job.service;

import com.jobdemo.job.data.CandidateRepository;
import com.jobdemo.job.data.JobRepository;
import com.jobdemo.job.service.mapping.JobMapper;
import com.jobdemo.job.service.model.CandidateInput;
import com.jobdemo.job.service.model.CandidateTo;
import com.jobdemo.job.service.model.JobInput;
import com.jobdemo.job.service.model.JobTo;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class JobService {

    private final JobRepository jobRepository;
    private final CandidateRepository candidateRepository;

    public List<JobTo> getAllJobs() {
        return JobMapper.I.jobsToTo(jobRepository.findAll());
    }

    @Transactional
    public JobTo createJob(JobInput input) {
        var entity = JobMapper.I.fromInput(input);
        return JobMapper.I.toTo(jobRepository.save(entity));
    }

    @Transactional
    public CandidateTo createCandidate(CandidateInput input) {
        var entity = JobMapper.I.fromInput(input);
        return JobMapper.I.toTo(candidateRepository.save(entity));
    }

    @Transactional
    public void assignCandidate(Long jobId, Long candidateId) {
        var job = jobRepository.findById(jobId).orElseThrow(() -> new EntityNotFoundException("Job not found"));
        var candidate = candidateRepository.findById(candidateId)
            .orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
        job.getCandidates().add(candidate);
    }

    @Transactional(readOnly = true)
    public List<CandidateTo> jobCandidates(Long jobId) {
        var job = jobRepository.findById(jobId).orElseThrow(() -> new EntityNotFoundException("Job not found"));
        return JobMapper.I.candidatesToTo(job.getCandidates());
    }
}
