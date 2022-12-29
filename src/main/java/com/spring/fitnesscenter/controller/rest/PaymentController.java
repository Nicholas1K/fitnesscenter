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

import com.spring.fitnesscenter.model.Payment;
import com.spring.fitnesscenter.service.PaymentService;



@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayment() {

        return new ResponseEntity<>(paymentService.getAllPayment(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Payment> getPaymentByID(@PathVariable long id) {

        return new ResponseEntity<>(paymentService.findPaymentByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePaymentByID(@PathVariable long id) {

        paymentService.deletePaymentByID(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment newPayment) {

        return new ResponseEntity<>(paymentService.savePayment(newPayment), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/")
    public ResponseEntity<Payment> updatePayment(@PathVariable long id, @RequestBody Payment newPayment) {

        return new ResponseEntity<>(paymentService.updatePayment(newPayment), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Payment> updatePaymentByID(@PathVariable long id, @RequestBody Payment newPayment) {

        return new ResponseEntity<>(paymentService.updatePaymentByID(id, newPayment), HttpStatus.OK);
    }
}
