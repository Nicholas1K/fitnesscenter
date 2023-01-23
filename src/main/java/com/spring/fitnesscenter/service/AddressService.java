package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.Address;
import com.spring.fitnesscenter.repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    AddressRepository addressRepository;

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }
    
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
    
    public Address findAddressByID(Long id){
        Optional<Address> tempA = addressRepository.findById(id);

        if(tempA.isPresent()){
            return tempA.get();
        }else{
            return null;
        }
    }
    
    public void deleteAddressByID(Long id){
        addressRepository.deleteById(id);
    }
    public Address updateAddress(Address newAddress){
        Address oldA = findAddressByID(newAddress.getId());

        if(oldA != null){
            oldA.setNation(newAddress.getNation());
            oldA.setRegion(newAddress.getRegion());
            oldA.setCity(newAddress.getCity());
            oldA.setProvince(newAddress.getProvince());
            oldA.setPostalCode(newAddress.getPostalCode());
            oldA.setHomeNumber(newAddress.getHomeNumber());
            
            return addressRepository.save(oldA);
        }
        return null;
    }
    
    public Address updateAddressByID(Long id, Address newAddress) {
        Optional<Address> tempOldA = addressRepository.findById(newAddress.getId());

        if (tempOldA.isPresent()) {
            Address oldAddress = tempOldA.get();
            
            oldAddress.setNation(newAddress.getNation());
            oldAddress.setRegion(newAddress.getRegion());
            oldAddress.setCity(newAddress.getCity());
            oldAddress.setProvince(newAddress.getProvince());
            oldAddress.setPostalCode(newAddress.getPostalCode());
            oldAddress.setHomeNumber(newAddress.getHomeNumber());

            return addressRepository.save(oldAddress);
           
        }
        return null;
    }
}
