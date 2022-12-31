package com.spring.fitnesscenter.controller.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.spring.fitnesscenter.model.Subscription;
import com.spring.fitnesscenter.service.SubscriptionService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class SubscriptionWeb {
    @Autowired
    SubscriptionService subscriptionService;

    //metodo Get che ritorna la lista degli Subscription

    @GetMapping({"/subscription"})
    public String showSubscription(Model model){
        model.addAttribute("subscription", subscriptionService.getAllSubscription());
        return "subscription";
    }
    //metodo Get che ritorna la tabella per inserire un nuovo subscription

    @GetMapping("/subscription/create")
    public String showSubscriptionForm(Model model) {
        Subscription subscription = new Subscription();
        model.addAttribute("subscription", subscription);
        return "subscription-create";
    }
    //metodo Post che salva un nuovo subscription

    @PostMapping("/subscription/create")
    public String insertSubscription(@ModelAttribute("subscription") Subscription subscription){
        subscriptionService.saveSubscription(subscription);
        return"redirect:/subscription";
    }

    //metodo Get che ritorna la tabella per modificare un subscription

    @GetMapping("/subscription/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("subscription", subscriptionService.findSubscriptionByID(id));
        return "update-subscription";
    }

    //metodo Post che modifica effettivamente il subscription

    @PostMapping("/subscription/{id}")
    public String updateSubscription(@PathVariable Long id,@ModelAttribute("subscription") Subscription subscription, Model model){
        Subscription oldSubscription = subscriptionService.findSubscriptionByID(id);
        
        oldSubscription.setType(subscription.getType());
        oldSubscription.setMonth(subscription.getMonth());
        oldSubscription.setPrice(subscription.getPrice());

        subscriptionService.updateSubscription(oldSubscription);
        return "redirect:/subscription";
    }

    //metodo Get per eliminare un subscription

    @GetMapping("/subscription/{id}")
    public String deleteSubscription(@PathVariable Long id){
        subscriptionService.deleteSubscriptionByID(id);
        return "redirect:/subscription";
    }

}
