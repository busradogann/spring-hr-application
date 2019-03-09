package com.busradogan.hrApplication.repository;

import java.util.Optional;

import com.busradogan.hrApplication.domain.Job;
import com.busradogan.hrApplication.domain.User;
import com.busradogan.hrApplication.service.UserService;

import org.springframework.data.repository.CrudRepository;


public interface JobRepository extends CrudRepository<Job, Long> {

	Job save(Optional<Job> job);

}