package com.spring.fitnesscenter.controller.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.spring.fitnesscenter.model.Course;
import com.spring.fitnesscenter.service.CourseService;

import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class CourseWeb {
    @Autowired
    CourseService courseService;

    //metodo Get che ritorna la lista dei corsi

    @GetMapping({"/course","/"})
    public String showCourse(Model model){
        model.addAttribute("course", courseService.getAllCourse());
        return "course";
    }
    //metodo Get che ritorna la tabella per inserire un nuovo corso

    @GetMapping("/course/create")
    public String showCourseForm(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "course-create";
    }
    //metodo Post che salva un nuovo corso

    @PostMapping("/course/create")
    public String insertCourse(@ModelAttribute("course") Course course){
        courseService.saveCourse(course);
        return"redirect:/course";
    }

    //metodo Get che ritorna la tabella per modificare un corso

    @GetMapping("/course/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model){
        model.addAttribute("course", courseService.findCourseByID(id));
        return "update-course";
    }

    //metodo Post che modifica effettivamente il corso

    @PostMapping("/course/{id}")
    public String updateCourse(@PathVariable Long id,@ModelAttribute("course") Course course, Model model){
        Course oldCourse = courseService.findCourseByID(id);
        oldCourse.setName(course.getName());

        courseService.updateCourse(oldCourse);
        return "redirect:/course";
    }

    //metodo Get per eliminare un corso

    @GetMapping("/course/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourseByID(id);
        return "redirect:/course";
    }

}
