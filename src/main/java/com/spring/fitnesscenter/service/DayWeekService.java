package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.DayWeek;
import com.spring.fitnesscenter.repository.DayWeekRepository;

@Service
public class DayWeekService {
    
    @Autowired
    DayWeekRepository dayWeekRepository;

    public DayWeek saveDayWeek(DayWeek dayWeek){
        return dayWeekRepository.save(dayWeek);
    }
    
    public List<DayWeek> getAllDayWeek(){
        return dayWeekRepository.findAll();
    }
    
    public DayWeek findDayWeekByID(Long id){
        Optional<DayWeek> tempD = dayWeekRepository.findById(id);

        if(tempD.isPresent()){
            return tempD.get();
        }else{
            return null;
        }
    }
    
    public void deleteDayWeekByID(Long id){
        dayWeekRepository.deleteById(id);
    }
    public DayWeek updateDayWeek(DayWeek newDayWeek){
        DayWeek oldD = findDayWeekByID(newDayWeek.getId());

        if(oldD != null){
            oldD.setDay(newDayWeek.getDay());
            oldD.setCourses(newDayWeek.getCourses());
            
            return dayWeekRepository.save(oldD);
        }
        return null;
    }
    
    public DayWeek updateDayWeekByID(Long id, DayWeek newDayWeek) {
        Optional<DayWeek> tempOldDay = dayWeekRepository.findById(newDayWeek.getId());

        if (tempOldDay.isPresent()) {
            DayWeek oldDayWeek = tempOldDay.get();

            oldDayWeek.setDay(newDayWeek.getDay());
            oldDayWeek.setCourses(newDayWeek.getCourses());

            return dayWeekRepository.save(oldDayWeek);

        }
        return null;
    }
}
