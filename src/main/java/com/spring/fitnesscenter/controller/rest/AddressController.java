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

import com.spring.fitnesscenter.model.Address;
import com.spring.fitnesscenter.service.AddressService;



@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/all")
    public ResponseEntity<List<Address>> getAllAddress() {

        return new ResponseEntity<>(addressService.getAllAddress(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Address> getAddressByID(@PathVariable long id) {

        return new ResponseEntity<>(addressService.findAddressByID(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressByID(@PathVariable long id) {

        addressService.deleteAddressByID(id);

        return new ResponseEntity<>("deleted successful", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Address> createAddress(@RequestBody Address newAddress) {

        return new ResponseEntity<>(addressService.saveAddress(newAddress), HttpStatus.CREATED);
    }
    
    @PutMapping("/update/")
    public ResponseEntity<Address> updateAddress(@PathVariable long id, @RequestBody Address newAddress) {

        return new ResponseEntity<>(addressService.updateAddress(newAddress), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Address> updateAddressByID(@PathVariable long id, @RequestBody Address newAddress) {

        return new ResponseEntity<>(addressService.updateAddressByID(id, newAddress), HttpStatus.OK);
    }
}
