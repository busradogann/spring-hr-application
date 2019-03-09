package com.busradogan.hrApplication.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class AppForm{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotEmpty
    @Column(name = "address", nullable = false)
    private String address;

    @NotEmpty
    @Column(name = "thoughts", nullable = false)
    private String thoughts;

    @NotEmpty
    @Column(name = "resume", nullable = false)
    private String resume;

    public AppForm(){

    }

    public AppForm(String name, String email, String phone, String address, String thoughts,
    String resume){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.thoughts = thoughts;
        this.resume = resume;
    }

    public long getId(){
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

    public String getPhone(){
        return phone; 
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getAddress(){
        return address; 
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getThoughts(){
        return thoughts; 
    }

    public void setThoughts(String thoughts){
        this.thoughts = thoughts;
    }

    public String getResume(){
        return resume; 
    }

    public void setResume(String resume){
        this.resume = resume;
    }
}