package com.jobdemo.job.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobName;
    private String description;
    private String location;

    @ManyToMany
    @JoinTable(
        name = "job_candidate",
        joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    )
    private List<Candidate> candidates = new ArrayList<>();
}
