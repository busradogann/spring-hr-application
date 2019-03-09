package com.busradogan.hrApplication.service;

import java.util.*;
import com.busradogan.hrApplication.domain.*;
import com.busradogan.hrApplication.repository.JobRepository;
import com.busradogan.hrApplication.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final UserService userService;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository, UserService userService) {
        this.jobRepository = jobRepository;
        this.userService = userService;
    }

    public void addJob(JobAddForm form) {
        Job job = new Job(form.getTitle(), form.getDescription(), form.getNumberOfPeople(), form.getLastApplication());
        jobRepository.save(job);
        System.out.println(jobRepository.findById(job.getId()));
    }

    @Override
    public Iterable<Job> getJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void deleteJobById(long id) {
        jobRepository.deleteById(id);
    }

    public Optional<Job> getJobById(long id) {
        return jobRepository.findById(id);
    }

    public Job assignJob(String name, long jobId) {
        Optional<User> user = userService.getUserByName(name);
        Optional<Job> job = getJobById(jobId);

        Optional <Job> jobList =  user.getJobs();
            jobList.add(job);
            user.setJobs(jobList);

        job.setUser(user);
        
        return jobRepository.save(job);
    }

    @Override
    public Optional <User> getUserById(long id) {
        return userRepository.findOne(id);
    }
        
    public Map<String, List<Job>> numberOfJobsByType(long userId) {
        Map<String, List<Job>> map = new HashMap<String, List<Job>>();
        Set<Job> jobs = getJobById(userId).getJobs();
        
        for (Job job: jobs) {
            List<Job> jobList = new ArrayList<Job>();
            String key = job.getTitle().toLowerCase();
        
            if (map.containsKey(key))
                    jobList = map.get(key);
                    jobList.add(job);
                    map.put(key, jobList);
        }
        return map;

    }

}

