package com.jobdemo.job.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.jobdemo.job.data.CandidateRepository;
import com.jobdemo.job.data.JobRepository;
import com.jobdemo.job.data.model.Candidate;
import com.jobdemo.job.data.model.Job;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({JobService.class})
class JobServiceTest {

    @Autowired
    private JobService service;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CandidateRepository candidateRepository;


    @Test
    public void shouldAssignCandidateToJob() {
        // given
        var job = new Job();
        job.setJobName("Job 1");
        job.setDescription("Description");
        job.setLocation("London");
        job = jobRepository.save(job);

        var candidate = new Candidate();
        candidate.setName("Johnny Depp");
        candidate.setExperience(20L);
        candidate = candidateRepository.save(candidate);

        // when
        service.assignCandidate(job.getId(), candidate.getId());
        var candidates = service.jobCandidates(job.getId());

        // then
        assertThat(candidates.size()).isEqualTo(1);
    }
}