package com.busradogan.hrApplication.domain;

import javax.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title; 

    @Column(name = "description", nullable = false)
    private String description; 

    @Column(name = "numberOfPeople", nullable = false)
    private int numberOfPeople;

    @Column(name = "lastApplicationDate", nullable = false)
    private String lastApplication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Job(){

    }

    public Job(String title, String description, int numberOfPeople, String lastApplication){
        this.title = title;
        this.description = description;
        this.numberOfPeople = numberOfPeople;
        this.lastApplication = lastApplication;
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title; 
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description; 
    }

    public void setDescription(String description){
        this.description = description;
    }


    public Integer getNumberOfPeople(){
        return numberOfPeople; 
    }

    public void setNumberOfPeople(Integer numberOfPeople){
        this.numberOfPeople = numberOfPeople;
    }

    public String getLastApplication(){
        return lastApplication; 
    }

    public void setLastApplication(String lastApplication){
        this.lastApplication = lastApplication;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", numberOfPeople='" + numberOfPeople + '\'' +
                ", lastApplication='" + lastApplication + '\'' +
                '}';
    }
}
