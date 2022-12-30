package com.spring.fitnesscenter.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index{

    @RequestMapping(value = { "/index", "/" })
    public ModelAndView getWelcomePage() {

        ModelAndView view = new ModelAndView();
        view.setViewName("index"); // Carica la pagina html che si chiama index.html

        return view;
    }

}
