package com.spring.fitnesscenter.controller.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.spring.fitnesscenter.model.DayAndTimeWork;
import com.spring.fitnesscenter.service.DayAndTimeWorkService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class DayAndTimeWorkWeb {
    @Autowired
    DayAndTimeWorkService dayAndTimeWorkService;

    //metodo Get che ritorna la lista degli DayAndTimeWork

    @GetMapping({"/dayAndTimeWork"})
    public String showDayAndTimeWork(Model model){
        model.addAttribute("dayAndTimeWork", dayAndTimeWorkService.getAllDayAndTimeWork());
        return "dayAndTimeWork";
    }
    //metodo Get che ritorna la tabella per inserire un nuovo dayAndTimeWork

    @GetMapping("/dayAndTimeWork/create")
    public String showDayAndTimeWorkForm(Model model) {
        DayAndTimeWork dayAndTimeWork = new DayAndTimeWork();
        model.addAttribute("dayAndTimeWork", dayAndTimeWork);
        return "dayAndTimeWork-create";
    }
    //metodo Post che salva un nuovo dayAndTimeWork

    @PostMapping("/dayAndTimeWork/create")
    public String insertDayAndTimeWork(@ModelAttribute("dayAndTimeWork") DayAndTimeWork dayAndTimeWork){
        dayAndTimeWorkService.saveDayAndTimeWork(dayAndTimeWork);
        return"redirect:/dayAndTimeWork";
    }

    //metodo Get che ritorna la tabella per modificare un dayAndTimeWork

    @GetMapping("/dayAndTimeWork/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("dayAndTimeWork", dayAndTimeWorkService.findDayAndTimeWorkByID(id));
        return "update-dayAndTimeWork";
    }

    //metodo Post che modifica effettivamente il dayAndTimeWork

    @PostMapping("/dayAndTimeWork/{id}")
    public String updateDayAndTimeWork(@PathVariable Long id,@ModelAttribute("dayAndTimeWork") DayAndTimeWork dayAndTimeWork, Model model){
        DayAndTimeWork oldDayAndTimeWork = dayAndTimeWorkService.findDayAndTimeWorkByID(id);
        
        oldDayAndTimeWork.setCoruse(dayAndTimeWork.getCoruse());
        oldDayAndTimeWork.setPersonalTrainers(dayAndTimeWork.getPersonalTrainers());
        oldDayAndTimeWork.setTimeTables(dayAndTimeWork.getTimeTables());

        dayAndTimeWorkService.updateDayAndTimeWork(oldDayAndTimeWork);
        return "redirect:/dayAndTimeWork";
    }

    //metodo Get per eliminare un dayAndTimeWork

    @GetMapping("/dayAndTimeWork/{id}")
    public String deleteDayAndTimeWork(@PathVariable Long id){
        dayAndTimeWorkService.deleteDayAndTimeWorkByID(id);
        return "redirect:/dayAndTimeWork";
    }

}
