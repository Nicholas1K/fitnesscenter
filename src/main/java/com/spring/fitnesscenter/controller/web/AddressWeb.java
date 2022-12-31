package com.spring.fitnesscenter.controller.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.spring.fitnesscenter.model.Address;
import com.spring.fitnesscenter.service.AddressService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class AddressWeb {
    @Autowired
    AddressService addressService;

    //metodo Get che ritorna la lista degli Address

    @GetMapping({"/address"})
    public String showAddress(Model model){
        model.addAttribute("address", addressService.getAllAddress());
        return "address";
    }
    //metodo Get che ritorna la tabella per inserire un nuovo address

    @GetMapping("/address/create")
    public String showAddressForm(Model model) {
        Address address = new Address();
        model.addAttribute("address", address);
        return "address-create";
    }
    //metodo Post che salva un nuovo address

    @PostMapping("/address/create")
    public String insertAddress(@ModelAttribute("address") Address address){
        addressService.saveAddress(address);
        return"redirect:/address";
    }

    //metodo Get che ritorna la tabella per modificare un address

    @GetMapping("/address/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("address", addressService.findAddressByID(id));
        return "update-address";
    }

    //metodo Post che modifica effettivamente il address

    @PostMapping("/address/{id}")
    public String updateAddress(@PathVariable Long id,@ModelAttribute("address") Address address, Model model){
        Address oldAddress = addressService.findAddressByID(id);
        
        oldAddress.setNation(address.getNation());
        oldAddress.setRegion(address.getRegion());
        oldAddress.setCity(address.getCity());
        oldAddress.setProvince(address.getProvince());
        oldAddress.setPostalCode(address.getPostalCode());
        oldAddress.setHomeNumber(address.getHomeNumber());

        addressService.updateAddress(oldAddress);
        return "redirect:/address";
    }

    //metodo Get per eliminare un address

    @GetMapping("/address/{id}")
    public String deleteAddress(@PathVariable Long id){
        addressService.deleteAddressByID(id);
        return "redirect:/address";
    }

}
