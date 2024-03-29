package com.spring.fitnesscenter.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class TimeTables { // orari
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String startTime;

    @Column
    private String endTime;

    @ManyToMany
    private List<DayWeek> dayOfTheWeek;

    @Column
    private String courses;

    public TimeTables() {
    }

    public TimeTables(String startTime, String endTime, List<DayWeek> dayOfTheWeek, String courses) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfTheWeek = dayOfTheWeek;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<DayWeek> getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(List<DayWeek> dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }
    
    public String getCourse() {
        return courses;
    }

    public void setCourse(String courses) {
        this.courses = courses;
    }

    

    @Override
    public String toString() {
        return + id + ", start = " + startTime + ", end = " + endTime + dayOfTheWeek;
    }

    
}
