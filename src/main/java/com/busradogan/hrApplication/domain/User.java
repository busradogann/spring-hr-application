package com.busradogan.hrApplication.domain;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.boot.autoconfigure.security.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @Size(min = 6, max = 20)
    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Job> jobs;

    public User(){

    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("USER");
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        list.add(simpleGrantedAuthority);
        return list;
}

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public String getUsername(){
        return name;
    }
	
}