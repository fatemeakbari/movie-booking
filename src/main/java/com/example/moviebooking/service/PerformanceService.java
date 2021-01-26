package com.example.moviebooking.service;


import com.example.moviebooking.repository.PerformanceRepository;
import com.example.moviebooking.entity.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    public Date getCurrentDate(){
        return new Date() ;
    }

    public Performance save(Performance performance){
        try{
            return performanceRepository.save(performance);
        }
        catch (NestedRuntimeException ex){
            if(ex.getMessage().contains("Unable to find")){
                throw new DataIntegrityViolationException("Please enter valid  media or place id");
            }
            throw new IllegalArgumentException("Please Enter valid data!");
        }
    }

    public Performance update(Long id,Performance performance){
        performance.setId(id);
        return performanceRepository.save(performance);
    }

    public Performance findById(Long id){
        try{
            return performanceRepository.findById(id).get();
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Performance not found with id: "+id);
        }
    }

    public List<Performance> findByMediaId(Long mediaId){
        return performanceRepository.findByMediaId(mediaId);
    }

    public List<Performance> findByPlaceId(Long placeId){
        return performanceRepository.findByPlaceId(placeId);
    }

    public List<Performance> findAll(){
        return (List<Performance>) performanceRepository.findAll();
    }

    public List<Performance> findByShowDate(Date showDate){
        return performanceRepository.findByShowDate(showDate);
    }

    public List<Performance> findAfterTodayDate(){
        return performanceRepository.findAfterTodayDate(getCurrentDate());
    }


    public List<Performance> findAfterTodayDateByMediaId(long mediaId) {
        return performanceRepository.findAfterTodayDateByMediaId(mediaId, getCurrentDate());
    }

    public List<Performance> findAfterTodayDateByPlaceId(long placeId) {
        return performanceRepository.findAfterTodayDateByPlaceId(placeId, getCurrentDate());
    }

    public void deleteById(Long id) {
        performanceRepository.deleteById(id);
    }
}
