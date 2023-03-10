package com.spring.fitnesscenter;

//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.spring.fitnesscenter.model.PersonalTrainer;
import com.spring.fitnesscenter.service.PersonalTrainerService;
//import com.spring.fitnesscenter.model.Course;
import com.spring.fitnesscenter.service.CourseService;

@Component
public class MyApplicationRunner implements CommandLineRunner {

    @Autowired
    PersonalTrainerService personalTrainerService;

    @Autowired
    CourseService courseService;

    @Override
    public void run(String... args) throws Exception {

       /*  ArrayList<Course> c1 = new ArrayList<>(List.of(courseService.findCourseByID(1L)));
        ArrayList<Course> c2 = new ArrayList<>(List.of(courseService.findCourseByID(2L)));

        PersonalTrainer pt1 = new PersonalTrainer("massimo", "giotto", LocalDate.of(1990, 03, 18),LocalDate.of(2023, 01,18) , 
                "Sal87bh10", "3299322736", "maTondo@myemail.it",c1);

                PersonalTrainer pt2 = new PersonalTrainer("pino", "autista", 
                        LocalDate.of(1991, 06, 20), LocalDate.of(2023, 03, 01), "Mjs90bh33", "3227731234", "pinorun@myemail.it", c2);

                  personalTrainerService.savePersonalTrainer(pt1);  
                  personalTrainerService.savePersonalTrainer(pt2);    */

    }
}
