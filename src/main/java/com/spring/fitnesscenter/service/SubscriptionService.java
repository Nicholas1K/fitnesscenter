package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.Subscription;
import com.spring.fitnesscenter.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
    
    @Autowired
    SubscriptionRepository subscriptionRepository;

    public Subscription saveSubscription(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }
    
    public List<Subscription> getAllSubscription(){
        return subscriptionRepository.findAll();
    }
    
    public Subscription findSubscriptionByID(Long id){
        Optional<Subscription> tempS = subscriptionRepository.findById(id);

        if(tempS.isPresent()){
            return tempS.get();
        }else{
            return null;
        }
    }
    
    public void deleteSubscriptionByID(Long id){
        subscriptionRepository.deleteById(id);
    }
    public Subscription updateSubscription(Subscription newSubscription){
        Subscription oldS = findSubscriptionByID(newSubscription.getId());

        if(oldS != null){
            oldS.setType(newSubscription.getType());
            oldS.setMonth(newSubscription.getMonth());
            oldS.setPrice(newSubscription.getPrice());
            
            subscriptionRepository.save(newSubscription);
        }
        return null;
    }
}
