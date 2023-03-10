package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.AddressPersonalT;
import com.spring.fitnesscenter.repository.AddressPTRepository;

@Service
public class AddressPTService {
    
    @Autowired
    AddressPTRepository addressPTRepository;

    public AddressPersonalT saveAddress(AddressPersonalT address){
        return addressPTRepository.save(address);
    }
    
    public List<AddressPersonalT> getAllAddress(){
        return addressPTRepository.findAll();
    }
    
    public AddressPersonalT findAddressByID(Long id){
        Optional<AddressPersonalT> tempA = addressPTRepository.findById(id);

        if(tempA.isPresent()){
            return tempA.get();
        }else{
            return null;
        }
    }
    
    public void deleteAddressByID(Long id){
        addressPTRepository.deleteById(id);
    }
    public AddressPersonalT updateAddress(AddressPersonalT newAddress){
        AddressPersonalT oldA = findAddressByID(newAddress.getId());

        if(oldA != null){
            oldA.setNation(newAddress.getNation());
            oldA.setRegion(newAddress.getRegion());
            oldA.setCity(newAddress.getCity());
            oldA.setProvince(newAddress.getProvince());
            oldA.setPostalCode(newAddress.getPostalCode());
            oldA.setHomeNumber(newAddress.getHomeNumber());
            
            return addressPTRepository.save(oldA);
        }
        return null;
    }
    
    public AddressPersonalT updateAddressByID(Long id, AddressPersonalT newAddress) {
        Optional<AddressPersonalT> tempOldA = addressPTRepository.findById(newAddress.getId());

        if (tempOldA.isPresent()) {
            AddressPersonalT oldAddress = tempOldA.get();
            
            oldAddress.setNation(newAddress.getNation());
            oldAddress.setRegion(newAddress.getRegion());
            oldAddress.setCity(newAddress.getCity());
            oldAddress.setProvince(newAddress.getProvince());
            oldAddress.setPostalCode(newAddress.getPostalCode());
            oldAddress.setHomeNumber(newAddress.getHomeNumber());

            return addressPTRepository.save(oldAddress);
           
        }
        return null;
    }
}
