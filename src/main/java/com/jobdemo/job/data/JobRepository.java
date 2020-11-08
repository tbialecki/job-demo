package com.jobdemo.job.data;

import com.jobdemo.job.data.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}


