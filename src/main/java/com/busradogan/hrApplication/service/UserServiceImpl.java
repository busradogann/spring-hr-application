package com.busradogan.hrApplication.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import com.busradogan.hrApplication.domain.User;
import com.busradogan.hrApplication.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<String>();
        Iterator iterator = getUsers().iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            names.add(user.getName());
        }
        return names;
    }

    public UserDetails loadUserByName(String name) throws NameNotFoundException {
        User user = getUserByName(name);
        if (null == user) {
            throw new NameNotFoundException("User with name: " + name + " not found.");
        }   
        else {
            return user;
        }
    }
}