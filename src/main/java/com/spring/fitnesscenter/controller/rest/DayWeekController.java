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

import com.spring.fitnesscenter.model.DayWeek;
import com.spring.fitnesscenter.service.DayWeekService;



@RestController
@RequestMapping("/api/dayWeek")
public class DayWeekController {

    @Autowired
    DayWeekService dayWeekService;

    @GetMapping("/all")
    public ResponseEntity<List<DayWeek>> getAllDayWeek() {

        return new ResponseEntity<>(dayWeekService.getAllDayWeek(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DayWeek> getDayWeekByID(@PathVariable long id) {

        return new ResponseEntity<>(dayWeekService.findDayWeekByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDayWeekByID(@PathVariable long id) {

        dayWeekService.deleteDayWeekByID(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<DayWeek> createDayWeek(@RequestBody DayWeek newDayWeek) {

        return new ResponseEntity<>(dayWeekService.saveDayWeek(newDayWeek), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/")
    public ResponseEntity<DayWeek> updateDayWeek(@PathVariable long id, @RequestBody DayWeek newDayWeek) {

        return new ResponseEntity<>(dayWeekService.updateDayWeek(newDayWeek), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DayWeek> updateDayWeekByID(@PathVariable long id, @RequestBody DayWeek newDayWeek) {

        return new ResponseEntity<>(dayWeekService.updateDayWeekByID(id, newDayWeek), HttpStatus.OK);
    }
}
