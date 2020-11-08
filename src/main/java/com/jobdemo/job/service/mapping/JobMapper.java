package com.jobdemo.job.service.mapping;

import com.jobdemo.job.data.model.Candidate;
import com.jobdemo.job.data.model.Job;
import com.jobdemo.job.service.model.CandidateInput;
import com.jobdemo.job.service.model.CandidateTo;
import com.jobdemo.job.service.model.JobInput;
import com.jobdemo.job.service.model.JobTo;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobMapper {

    JobMapper I = Mappers.getMapper(JobMapper.class);

    List<JobTo> jobsToTo(List<Job> jobs);

    JobTo toTo(Job job);

    CandidateTo toTo(Candidate candidate);

    Job fromInput(JobInput input);

    Candidate fromInput(CandidateInput input);

    List<CandidateTo> candidatesToTo(List<Candidate> candidates);
}
