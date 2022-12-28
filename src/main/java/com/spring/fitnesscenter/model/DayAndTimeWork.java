package com.spring.fitnesscenter.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class DayAndTimeWork {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private List<Course> coruse;

    @ManyToMany
    private List<TimeTables> timeTables; //orari

    @ManyToMany
    private List<PersonalTrainer> personalTrainers;

    public DayAndTimeWork() {
    }

    public DayAndTimeWork(List<Course> coruse, List<TimeTables> timeTables, List<PersonalTrainer> personalTrainers) {
        this.coruse = coruse;
        this.timeTables = timeTables;
        this.personalTrainers = personalTrainers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Course> getCoruse() {
        return coruse;
    }

    public void setCoruse(List<Course> coruse) {
        this.coruse = coruse;
    }

    public List<TimeTables> getTimeTables() {
        return timeTables;
    }

    public void setTimeTables(List<TimeTables> timeTables) {
        this.timeTables = timeTables;
    }

    public List<PersonalTrainer> getPersonalTrainers() {
        return personalTrainers;
    }

    public void setPersonalTrainers(List<PersonalTrainer> personalTrainers) {
        this.personalTrainers = personalTrainers;
    }

    
}
