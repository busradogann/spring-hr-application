package com.busradogan.hrApplication.repository;

import java.util.Optional;

import com.busradogan.hrApplication.domain.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByName(String name);

}