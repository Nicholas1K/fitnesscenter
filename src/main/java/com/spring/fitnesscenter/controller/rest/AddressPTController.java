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

import com.spring.fitnesscenter.model.AddressPersonalT;
import com.spring.fitnesscenter.service.AddressPTService;



@RestController
@RequestMapping("/api/addressPersonalT")
@CrossOrigin
public class AddressPTController {

    @Autowired
    AddressPTService addressPTService;

    @GetMapping("/all")
    public ResponseEntity<List<AddressPersonalT>> getAllAddress() {

        return new ResponseEntity<>(addressPTService.getAllAddress(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AddressPersonalT> getAddressByID(@PathVariable long id) {

        return new ResponseEntity<>(addressPTService.findAddressByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressByID(@PathVariable long id) {

        addressPTService.deleteAddressByID(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AddressPersonalT> createAddress(@RequestBody AddressPersonalT newAddress) {

        return new ResponseEntity<>(addressPTService.saveAddress(newAddress), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/")
    public ResponseEntity<AddressPersonalT> updateAddress(@PathVariable long id, @RequestBody AddressPersonalT newAddress) {

        return new ResponseEntity<>(addressPTService.updateAddress(newAddress), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressPersonalT> updateAddressByID(@PathVariable long id, @RequestBody AddressPersonalT newAddress) {

        return new ResponseEntity<>(addressPTService.updateAddressByID(id, newAddress), HttpStatus.OK);
    }
}
