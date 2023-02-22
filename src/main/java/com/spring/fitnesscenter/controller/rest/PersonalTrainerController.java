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

import com.spring.fitnesscenter.model.PersonalTrainer;
import com.spring.fitnesscenter.service.PersonalTrainerService;



@RestController
@RequestMapping("/api/personalTrainer")
@CrossOrigin
public class PersonalTrainerController {

    @Autowired
    PersonalTrainerService personalTrainerService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonalTrainer>> getAllPersonalTrainer() {

        return new ResponseEntity<>(personalTrainerService.getAllPersonalTrainer(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PersonalTrainer> getPersonalTrainerByID(@PathVariable long id) {

        return new ResponseEntity<>(personalTrainerService.findPersonalTrainerByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePersonalTrainerByID(@PathVariable long id) {

        personalTrainerService.deletePersonalTrainerByID(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PersonalTrainer> createPersonalTrainer(@RequestBody PersonalTrainer newPersonalTrainer) {

        return new ResponseEntity<>(personalTrainerService.savePersonalTrainer(newPersonalTrainer), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/")
    public ResponseEntity<PersonalTrainer> updatePersonalTrainer(@PathVariable long id, @RequestBody PersonalTrainer newPersonalTrainer) {

        return new ResponseEntity<>(personalTrainerService.updatePersonalTrainer(newPersonalTrainer), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PersonalTrainer> updatePersonalTrainerByID(@PathVariable long id, @RequestBody PersonalTrainer newPersonalTrainer) {

        return new ResponseEntity<>(personalTrainerService.updatePersonalTrainerByID(id, newPersonalTrainer), HttpStatus.OK);
    }
}
