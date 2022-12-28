package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.Course;
import com.spring.fitnesscenter.repository.CourseRepository;

@Service
public class CourseService {
    
    @Autowired
    CourseRepository courseRepository;

    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }
    
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }
    
    public Course findCourseByID(Long id){
        Optional<Course> tempC = courseRepository.findById(id);

        if(tempC.isPresent()){
            return tempC.get();
        }else{
            return null;
        }
    }
    
    public void deleteCourseByID(Long id){
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Course newCourse){
        Course oldC = findCourseByID(newCourse.getId());

        if(oldC != null){
            oldC.setName(newCourse.getName());

            courseRepository.save(newCourse);
        }
        return null;
    }
    
    public Course updateCourseByID(Long id,Course newCourse) {
         Optional<Course> tempOldC = courseRepository.findById(newCourse.getId());

         if(tempOldC.isPresent()){
            Course oldCourse = tempOldC.get();

            oldCourse.setName(newCourse.getName());

            courseRepository.save(newCourse);
        }
        return null;
    }
}
