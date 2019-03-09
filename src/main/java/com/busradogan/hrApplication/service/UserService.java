package com.busradogan.hrApplication.service;

import java.util.List;
import java.util.Optional;

import com.busradogan.hrApplication.domain.User;


public interface UserService {
    Optional<User> getUserById(long id);

    Optional<User> getUserByUsername(String username);

    User addUser(User user);

    Iterable<User> getUsers();

    List<String> getUsernames();
}
