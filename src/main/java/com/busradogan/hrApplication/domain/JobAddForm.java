package com.busradogan.hrApplication.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class JobAddForm{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotNull
    private int numberOfPeople = 1 ;

    @NotEmpty
    private String lastApplication;

    public JobAddForm(){

    }

    public JobAddForm(String title, String description, int numberOfPeople, String lastApplication){
        this.title = title;
        this.description = description;
        this.numberOfPeople = numberOfPeople;
        this.lastApplication = lastApplication;
    }

    public long getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
            this.numberOfPeople = numberOfPeople;
        }
        public String getLastApplication() {
            return lastApplication;
        }
    public void setLastApplication(String lastApplication) {
            this.lastApplication = lastApplication;
        }
}