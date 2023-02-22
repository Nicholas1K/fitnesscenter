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

import com.spring.fitnesscenter.model.Subscription;
import com.spring.fitnesscenter.service.SubscriptionService;



@RestController
@RequestMapping("/api/subscription")
@CrossOrigin
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("/all")
    public ResponseEntity<List<Subscription>> getAllSubscription() {

        return new ResponseEntity<>(subscriptionService.getAllSubscription(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Subscription> getSubscriptionByID(@PathVariable long id) {

        return new ResponseEntity<>(subscriptionService.findSubscriptionByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubscriptionByID(@PathVariable long id) {

        subscriptionService.deleteSubscriptionByID(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription newSubscription) {

        return new ResponseEntity<>(subscriptionService.saveSubscription(newSubscription), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable long id, @RequestBody Subscription newSubscription) {

        return new ResponseEntity<>(subscriptionService.updateSubscription(newSubscription), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Subscription> updateSubscriptionByID(@PathVariable long id, @RequestBody Subscription newSubscription) {

        return new ResponseEntity<>(subscriptionService.updateSubscriptionByID(id, newSubscription), HttpStatus.OK);
    }
}
