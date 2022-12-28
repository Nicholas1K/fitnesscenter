package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.User;
import com.spring.fitnesscenter.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
    
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    
    public User findUserByID(Long id){
        Optional<User> tempU = userRepository.findById(id);

        if(tempU.isPresent()){
            return tempU.get();
        }else{
            return null;
        }
    }
    
    public void deleteUserByID(Long id){
        userRepository.deleteById(id);
    }
    public User updateUser(User newUser){
        User oldU = findUserByID(newUser.getId());

        if(oldU != null){
            oldU.setFirstName(newUser.getFirstName());
            oldU.setLastName(newUser.getLastName());
            oldU.setDateOfBirth(newUser.getDateOfBirth());
            oldU.setFiscalCode(newUser.getFiscalCode());
            oldU.setTelephoneNumber(newUser.getTelephoneNumber());
            oldU.setEmail(newUser.getEmail());
            oldU.setCourse(newUser.getCourse());
            oldU.setSubscription(newUser.getSubscription());

            
            userRepository.save(newUser);
        }
        return null;
    }
}
