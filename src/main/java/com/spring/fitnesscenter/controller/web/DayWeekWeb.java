package com.spring.fitnesscenter.controller.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.spring.fitnesscenter.model.DayWeek;
import com.spring.fitnesscenter.service.DayWeekService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class DayWeekWeb {
    @Autowired
    DayWeekService dayWeekService;

    //metodo Get che ritorna la lista degli DayWeek

    @GetMapping({"/dayWeek"})
    public String showDayWeek(Model model){
        model.addAttribute("dayWeek", dayWeekService.getAllDayWeek());
        return "dayWeek";
    }
    //metodo Get che ritorna la tabella per inserire un nuovo dayWeek

    @GetMapping("/dayWeek/create")
    public String showDayWeekForm(Model model) {
        DayWeek dayWeek = new DayWeek();
        model.addAttribute("dayWeek", dayWeek);
        return "dayWeek-create";
    }
    //metodo Post che salva un nuovo dayWeek

    @PostMapping("/dayWeek/create")
    public String insertDayWeek(@ModelAttribute("dayWeek") DayWeek dayWeek){
        dayWeekService.saveDayWeek(dayWeek);
        return"redirect:/dayWeek";
    }

    //metodo Get che ritorna la tabella per modificare un dayWeek

    @GetMapping("/dayWeek/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("dayWeek", dayWeekService.findDayWeekByID(id));
        return "update-dayWeek";
    }

    //metodo Post che modifica effettivamente il dayWeek

    @PostMapping("/dayWeek/{id}")
    public String updateDayWeek(@PathVariable Long id,@ModelAttribute("dayWeek") DayWeek dayWeek, Model model){
        DayWeek oldDayWeek = dayWeekService.findDayWeekByID(id);
        
        oldDayWeek.setDay(dayWeek.getDay());
        oldDayWeek.setCourses(dayWeek.getCourses());

        dayWeekService.updateDayWeek(oldDayWeek);
        return "redirect:/dayWeek";
    }

    //metodo Get per eliminare un dayWeek

    @GetMapping("/dayWeek/{id}")
    public String deleteDayWeek(@PathVariable Long id){
        dayWeekService.deleteDayWeekByID(id);
        return "redirect:/dayWeek";
    }

}
