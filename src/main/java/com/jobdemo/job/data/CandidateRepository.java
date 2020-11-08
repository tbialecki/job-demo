package com.jobdemo.job.data;

import com.jobdemo.job.data.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}


