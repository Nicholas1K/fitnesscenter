package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.PersonalTrainer;
import com.spring.fitnesscenter.repository.PersonalTrainerRepository;

@Service
public class PersonalTrainerService {
    
    @Autowired
    PersonalTrainerRepository personalTrainerRepository;

    public PersonalTrainer savePersonalTrainer(PersonalTrainer personalTrainer){
        return personalTrainerRepository.save(personalTrainer);
    }
    
    public List<PersonalTrainer> getAllPersonalTrainer(){
        return personalTrainerRepository.findAll();
    }
    
    public PersonalTrainer findPersonalTrainerByID(Long id){
        Optional<PersonalTrainer> tempP = personalTrainerRepository.findById(id);

        if(tempP.isPresent()){
            return tempP.get();
        }else{
            return null;
        }
    }
    
    public void deletePersonalTrainerByID(Long id){
        personalTrainerRepository.deleteById(id);
    }
    public PersonalTrainer updatePersonalTrainer(PersonalTrainer newPersonalTrainer){
        PersonalTrainer oldP = findPersonalTrainerByID(newPersonalTrainer.getId());

        if(oldP != null){
            oldP.setFirstName(newPersonalTrainer.getFirstName());
            oldP.setLastName(newPersonalTrainer.getLastName());
            oldP.setDateOfBirth(newPersonalTrainer.getDateOfBirth());
            oldP.setWorkStart(newPersonalTrainer.getWorkStart());
            oldP.setFiscalCode(newPersonalTrainer.getFiscalCode());
            oldP.setTelephoneNumber(newPersonalTrainer.getTelephoneNumber());
            oldP.setEmail(newPersonalTrainer.getEmail());
            oldP.setCourses(newPersonalTrainer.getCourses());
            
            personalTrainerRepository.save(newPersonalTrainer);
        }
        return null;
    }
}
