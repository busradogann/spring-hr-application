package com.busradogan.hrApplication.service;

import java.util.Optional;
import java.util.Set;

import com.busradogan.hrApplication.domain.Job;
import com.busradogan.hrApplication.domain.JobAddForm;
import com.busradogan.hrApplication.domain.User;


public interface JobService {
    public void addJob(JobAddForm form);

    public void deleteJobById(long id);

    public Optional<Job> getJobById(long id);
    
    public Job assignJob(String name, long jobId);

    public Optional<User> getUserByName(String name); 
    
    public Optional<User> getUserById(long id);

    public Iterable<Job> getJobs();

}