package com.spring.fitnesscenter.controller.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.spring.fitnesscenter.model.PersonalTrainer;
import com.spring.fitnesscenter.service.PersonalTrainerService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class PersonalTrainerWeb {
    @Autowired
    PersonalTrainerService personalTrainerService;

    //metodo Get che ritorna la lista degli PersonalTrainer

    @GetMapping({"/personalTrainer"})
    public String showPersonalTrainer(Model model){
        model.addAttribute("personalTrainer", personalTrainerService.getAllPersonalTrainer());
        return "personalTrainer";
    }
    //metodo Get che ritorna la tabella per inserire un nuovo personalTrainer

    @GetMapping("/personalTrainer/create")
    public String showPersonalTrainerForm(Model model) {
        PersonalTrainer personalTrainer = new PersonalTrainer();
        model.addAttribute("personalTrainer", personalTrainer);
        return "personalTrainer-create";
    }
    //metodo Post che salva un nuovo personalTrainer

    @PostMapping("/personalTrainer/create")
    public String insertPersonalTrainer(@ModelAttribute("personalTrainer") PersonalTrainer personalTrainer){
        personalTrainerService.savePersonalTrainer(personalTrainer);
        return"redirect:/address/create";
    }

    //metodo Get che ritorna la tabella per modificare un personalTrainer

    @GetMapping("/personalTrainer/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("personalTrainer", personalTrainerService.findPersonalTrainerByID(id));
        return "update-personalTrainer";
    }

    //metodo Post che modifica effettivamente il personalTrainer

    @PostMapping("/personalTrainer/{id}")
    public String updatePersonalTrainer(@PathVariable Long id,@ModelAttribute("personalTrainer") PersonalTrainer personalTrainer, Model model){
        PersonalTrainer oldPersonalTrainer = personalTrainerService.findPersonalTrainerByID(id);
        
        oldPersonalTrainer.setFirstName(personalTrainer.getFirstName());
        oldPersonalTrainer.setLastName(personalTrainer.getLastName());
        oldPersonalTrainer.setDateOfBirth(personalTrainer.getDateOfBirth());
        oldPersonalTrainer.setWorkStart(personalTrainer.getWorkStart());
        oldPersonalTrainer.setFiscalCode(personalTrainer.getFiscalCode());
        oldPersonalTrainer.setTelephoneNumber(personalTrainer.getTelephoneNumber());
        oldPersonalTrainer.setEmail(personalTrainer.getEmail());
        oldPersonalTrainer.setCourses(personalTrainer.getCourses());

        personalTrainerService.updatePersonalTrainer(oldPersonalTrainer);
        return "redirect:/personalTrainer";
    }

    //metodo Get per eliminare un personalTrainer

    @GetMapping("/personalTrainer/{id}")
    public String deletePersonalTrainer(@PathVariable Long id){
        personalTrainerService.deletePersonalTrainerByID(id);
        return "redirect:/personalTrainer";
    }

}
