package com.example.moviebooking.service.place;

import com.example.moviebooking.entity.place.Hall;
import com.example.moviebooking.repository.place.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    public Hall save(Hall hall){
        try{
            return hallRepository.save(hall);
        }
        catch (NestedRuntimeException ex){
         if(ex.getRootCause().getMessage().contains("limitation")){
                throw new DataIntegrityViolationException("limitation in number of hall for place");
            }
            throw new DataIntegrityViolationException("Not found place with id: "+hall.getPlace().getId());

        }
    }

    public boolean saveList(List<Hall> hallList){
        try{
            hallRepository.saveAll(hallList);
            return true;
        }
        catch (NestedRuntimeException ex){

            if(ex.getRootCause().getMessage().contains("Unable to find")){
                throw new EntityNotFoundException("The place with id: "+hallList.get(0).getPlace().getId()+" not exist!");
            }
            else if(ex.getRootCause().getMessage().contains("limitation")){
                throw new DataIntegrityViolationException("limitation in number of hall for place");
            }
            throw new DataIntegrityViolationException("Please Insert valid information");

        }
    }
    public Hall update(Long id, Hall hall){
        hall.setId(id);
        return hallRepository.save(hall);
    }

    public Hall findById(long id){
        try{
            return hallRepository.findById(id).get();
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Hall not found by id: "+id);
        }
    }

    public Page<Hall> findAll(Pageable pageable){
        return hallRepository.findAll(pageable);
    }

    public List<Hall> findAll(){
        return (List<Hall>) hallRepository.findAll();
    }

    public List<Hall>findByPlaceId(long placeId){
        try{
            return hallRepository.findByPlaceId(placeId);
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Hall not found by place id: "+placeId);
        }
    }

    public void deleteById(long id){
        try{
            hallRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException ex){
            throw new DataIntegrityViolationException("Hall not found by id: "+id);
        }
        catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("integrity constraint -> "+ex.getMessage());
        }

    }

}
