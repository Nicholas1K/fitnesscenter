package com.spring.fitnesscenter.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.fitnesscenter.model.DayAndTimeWork;
import com.spring.fitnesscenter.service.DayAndTimeWorkService;



@RestController
@RequestMapping("/api/dayAndTimeWork")
public class DayAndTimeWorkController {

    @Autowired
    DayAndTimeWorkService dayAndTimeWorkService;

    @GetMapping("/all")
    public ResponseEntity<List<DayAndTimeWork>> getAllDayAndTimeWork() {

        return new ResponseEntity<>(dayAndTimeWorkService.getAllDayAndTimeWork(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DayAndTimeWork> getDayAndTimeWorkByID(@PathVariable long id) {

        return new ResponseEntity<>(dayAndTimeWorkService.findDayAndTimeWorkByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDayAndTimeWorkByID(@PathVariable long id) {

        dayAndTimeWorkService.deleteDayAndTimeWorkByID(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<DayAndTimeWork> createDayAndTimeWork(@RequestBody DayAndTimeWork newDayAndTimeWork) {

        return new ResponseEntity<>(dayAndTimeWorkService.saveDayAndTimeWork(newDayAndTimeWork), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/")
    public ResponseEntity<DayAndTimeWork> updateDayAndTimeWork(@PathVariable long id, @RequestBody DayAndTimeWork newDayAndTimeWork) {

        return new ResponseEntity<>(dayAndTimeWorkService.updateDayAndTimeWork(newDayAndTimeWork), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DayAndTimeWork> updateDayAndTimeWorkByID(@PathVariable long id, @RequestBody DayAndTimeWork newDayAndTimeWork) {

        return new ResponseEntity<>(dayAndTimeWorkService.updateDayAndTimeWorkByID(id, newDayAndTimeWork), HttpStatus.OK);
    }
}
