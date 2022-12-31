package com.spring.fitnesscenter.controller.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.spring.fitnesscenter.model.TimeTables;
import com.spring.fitnesscenter.service.TimeTablesService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class TimeTablesWeb {
    @Autowired
    TimeTablesService timeTablesService;

    //metodo Get che ritorna la lista degli TimeTables

    @GetMapping({"/timeTables"})
    public String showTimeTables(Model model){
        model.addAttribute("timeTables", timeTablesService.getAllTimeTables());
        return "timeTables";
    }
    //metodo Get che ritorna la tabella per inserire un nuovo timeTables

    @GetMapping("/timeTables/create")
    public String showTimeTablesForm(Model model) {
        TimeTables timeTables = new TimeTables();
        model.addAttribute("timeTables", timeTables);
        return "timeTables-create";
    }
    //metodo Post che salva un nuovo timeTables

    @PostMapping("/timeTables/create")
    public String insertTimeTables(@ModelAttribute("timeTables") TimeTables timeTables){
        timeTablesService.saveTimeTables(timeTables);
        return"redirect:/timeTables";
    }

    //metodo Get che ritorna la tabella per modificare un timeTables

    @GetMapping("/timeTables/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("timeTables", timeTablesService.findTimeTablesByID(id));
        return "update-timeTables";
    }

    //metodo Post che modifica effettivamente il timeTables

    @PostMapping("/timeTables/{id}")
    public String updateTimeTables(@PathVariable Long id,@ModelAttribute("timeTables") TimeTables timeTables, Model model){
        TimeTables oldTimeTables = timeTablesService.findTimeTablesByID(id);
        
        oldTimeTables.setStartTime(timeTables.getStartTime());
        oldTimeTables.setEndTime(timeTables.getEndTime());
        oldTimeTables.setDayOfTheWeek(timeTables.getDayOfTheWeek());

        timeTablesService.updateTimeTables(oldTimeTables);
        return "redirect:/timeTables";
    }

    //metodo Get per eliminare un timeTables

    @GetMapping("/timeTables/{id}")
    public String deleteTimeTables(@PathVariable Long id){
        timeTablesService.deleteTimeTablesByID(id);
        return "redirect:/timeTables";
    }

}
