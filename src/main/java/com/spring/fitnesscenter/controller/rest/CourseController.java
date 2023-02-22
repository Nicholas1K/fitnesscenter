package com.spring.fitnesscenter.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fitnesscenter.model.Course;
import com.spring.fitnesscenter.service.CourseService;



@RestController
@RequestMapping("/api/course")
@CrossOrigin
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourse() {

        return new ResponseEntity<>(courseService.getAllCourse(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Course> getCourseByID(@PathVariable long id) {

        return new ResponseEntity<>(courseService.findCourseByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourseByID(@PathVariable long id) {

        courseService.deleteCourseByID(id);

        return new ResponseEntity<>("deleted course successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course newCourse) {

        return new ResponseEntity<>(courseService.saveCourse(newCourse), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/")
    public ResponseEntity<Course> updateCourse(@PathVariable long id, @RequestBody Course newCourse) {

        return new ResponseEntity<>(courseService.updateCourse(newCourse), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourseByID(@PathVariable long id, @RequestBody Course newCourse) {

        return new ResponseEntity<>(courseService.updateCourseByID(id, newCourse), HttpStatus.OK);
    }
}
