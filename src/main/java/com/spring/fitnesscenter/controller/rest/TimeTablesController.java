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

import com.spring.fitnesscenter.model.TimeTables;
import com.spring.fitnesscenter.service.TimeTablesService;



@RestController
@RequestMapping("/api/timeTables")
public class TimeTablesController {

    @Autowired
    TimeTablesService timeTablesService;

    @GetMapping("/all")
    public ResponseEntity<List<TimeTables>> getAllTimeTables() {

        return new ResponseEntity<>(timeTablesService.getAllTimeTables(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TimeTables> getTimeTablesByID(@PathVariable long id) {

        return new ResponseEntity<>(timeTablesService.findTimeTablesByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTimeTablesByID(@PathVariable long id) {

        timeTablesService.deleteTimeTablesByID(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<TimeTables> createTimeTables(@RequestBody TimeTables newTimeTables) {

        return new ResponseEntity<>(timeTablesService.saveTimeTables(newTimeTables), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/")
    public ResponseEntity<TimeTables> updateTimeTables(@PathVariable long id, @RequestBody TimeTables newTimeTables) {

        return new ResponseEntity<>(timeTablesService.updateTimeTables(newTimeTables), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TimeTables> updateTimeTablesByID(@PathVariable long id, @RequestBody TimeTables newTimeTables) {

        return new ResponseEntity<>(timeTablesService.updateTimeTablesByID(id, newTimeTables), HttpStatus.OK);
    }
}
