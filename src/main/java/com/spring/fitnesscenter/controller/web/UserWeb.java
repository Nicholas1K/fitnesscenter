package com.spring.fitnesscenter.controller.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.spring.fitnesscenter.model.User;
import com.spring.fitnesscenter.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class UserWeb {
    @Autowired
    UserService userService;

    //metodo Get che ritorna la lista degli User

    @GetMapping({"/user"})
    public String showUser(Model model){
        model.addAttribute("user", userService.getAllUser());
        return "user";
    }
    //metodo Get che ritorna la tabella per inserire un nuovo user

    @GetMapping("/user/create")
    public String showUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-create";
    }
    //metodo Post che salva un nuovo user

    @PostMapping("/user/create")
    public String insertUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return"redirect:/payment/create";
    }

    //metodo Get che ritorna la tabella per modificare un user

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.findUserByID(id));
        return "update-user";
    }

    //metodo Post che modifica effettivamente il user

    @PostMapping("/user/{id}")
    public String updateUser(@PathVariable Long id,@ModelAttribute("user") User user, Model model){
        User oldUser = userService.findUserByID(id);
        
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setDateOfBirth(user.getDateOfBirth());
        oldUser.setFiscalCode(user.getFiscalCode());
        oldUser.setTelephoneNumber(user.getTelephoneNumber());
        oldUser.setEmail(user.getEmail());
        oldUser.setCourses(user.getCourses());
        oldUser.setSubscription(user.getSubscription());

        userService.updateUser(oldUser);
        return "redirect:/user";
    }

    //metodo Get per eliminare un user

    @GetMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUserByID(id);
        return "redirect:/user";
    }

}
