package com.spring.fitnesscenter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fitnesscenter.model.DayAndTimeWork;
import com.spring.fitnesscenter.repository.DayAndTimeWorkRepository;

@Service
public class DayAndTimeWorkService {
    
    @Autowired
    DayAndTimeWorkRepository dayAndTimeWorkRepository;

    public DayAndTimeWork saveDayAndTimeWork(DayAndTimeWork dayAndTimeWork){
        return dayAndTimeWorkRepository.save(dayAndTimeWork);
    }
    
    public List<DayAndTimeWork> getAllDayAndTimeWork(){
        return dayAndTimeWorkRepository.findAll();
    }
    
    public DayAndTimeWork findDayAndTimeWorkByID(Long id){
        Optional<DayAndTimeWork> tempDay = dayAndTimeWorkRepository.findById(id);

        if(tempDay.isPresent()){
            return tempDay.get();
        }else{
            return null;
        }
    }
    
    public void deleteDayAndTimeWorkByID(Long id){
        dayAndTimeWorkRepository.deleteById(id);
    }
    public DayAndTimeWork updateDayAndTimeWork(DayAndTimeWork newDayAndTimeWork){
        DayAndTimeWork oldDay = findDayAndTimeWorkByID(newDayAndTimeWork.getId());

        if(oldDay != null){
            oldDay.setCoruse(newDayAndTimeWork.getCoruse());
            oldDay.setPersonalTrainers(newDayAndTimeWork.getPersonalTrainers());
            oldDay.setTimeTables(newDayAndTimeWork.getTimeTables());
            
            dayAndTimeWorkRepository.save(oldDay);
        }
        return null;
    }
    
    public DayAndTimeWork updateDayAndTimeWorkByID(Long id, DayAndTimeWork newDayAndTimeWork) {
        Optional<DayAndTimeWork> tempOldDay = dayAndTimeWorkRepository.findById(newDayAndTimeWork.getId());

        if (tempOldDay.isPresent()) {
            DayAndTimeWork oldDayAndTimeWork = tempOldDay.get();

            oldDayAndTimeWork.setCoruse(newDayAndTimeWork.getCoruse());
            oldDayAndTimeWork.setPersonalTrainers(newDayAndTimeWork.getPersonalTrainers());
            oldDayAndTimeWork.setTimeTables(newDayAndTimeWork.getTimeTables());

            dayAndTimeWorkRepository.save(oldDayAndTimeWork);

        }
        return null;
    }
}
