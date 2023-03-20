package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.TimeTables;
import com.spring.fitnesscenter.repository.TimeTablesRepository;

@Service
public class TimeTablesService {
    
    @Autowired
    TimeTablesRepository timeTablesRepository;

    public TimeTables saveTimeTables(TimeTables timeTables){
        return timeTablesRepository.save(timeTables);
    }
    
    public List<TimeTables> getAllTimeTables(){
        return timeTablesRepository.findAll();
    }
    
    public TimeTables findTimeTablesByID(Long id){
        Optional<TimeTables> tempT = timeTablesRepository.findById(id);

        if(tempT.isPresent()){
            return tempT.get();
        }else{
            return null;
        }
    }
    
    public void deleteTimeTablesByID(Long id){
        timeTablesRepository.deleteById(id);
    }
    public TimeTables updateTimeTables(TimeTables newTimeTables){
        TimeTables oldT = findTimeTablesByID(newTimeTables.getId());

        if(oldT != null){
            oldT.setStartTime(newTimeTables.getStartTime());
            oldT.setEndTime(newTimeTables.getEndTime());
            oldT.setDayOfTheWeek(newTimeTables.getDayOfTheWeek());
            oldT.setCourse(newTimeTables.getCourse());
            
            return timeTablesRepository.save(oldT);
        }
        return null;
    }
    
    public TimeTables updateTimeTablesByID(Long id, TimeTables newTimeTables) {
        Optional<TimeTables> tempOldTimeTables = timeTablesRepository.findById(newTimeTables.getId());

        if (tempOldTimeTables.isPresent()) {
            TimeTables oldTimeTables = tempOldTimeTables.get();

            oldTimeTables.setStartTime(newTimeTables.getStartTime());
            oldTimeTables.setEndTime(newTimeTables.getEndTime());
            oldTimeTables.setDayOfTheWeek(newTimeTables.getDayOfTheWeek());
            oldTimeTables.setCourse(newTimeTables.getCourse());

            return timeTablesRepository.save(oldTimeTables);
            

        }
        return null;
    }
}
