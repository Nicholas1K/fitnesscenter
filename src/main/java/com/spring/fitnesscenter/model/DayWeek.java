package com.spring.fitnesscenter.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class DayWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String day;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate currentDay;

    @ManyToMany
    private List<Course> courses;

    public DayWeek() {
    }

    public DayWeek(String day, LocalDate currentDay, List<Course> courses) {
        this.day = day;
        this.currentDay = currentDay;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalDate getcurrentDay() {
        return currentDay;
    }

    public void setcurrentDay(LocalDate currentDay) {
        this.currentDay = currentDay;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return day;
    }

    
}
