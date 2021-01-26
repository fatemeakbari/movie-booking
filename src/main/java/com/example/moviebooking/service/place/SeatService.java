package com.example.moviebooking.service.place;


import com.example.moviebooking.entity.place.Seat;
import com.example.moviebooking.repository.place.customRepositoryImpl.CustomSeatRepository;
import com.example.moviebooking.repository.place.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private CustomSeatRepository customSeatRepository;


    public Seat save(Seat seat){
        try{
            seat.setBooked(false);
            return seatRepository.save(seat);
        }
        catch (NestedRuntimeException ex){

            if(ex.getRootCause().getMessage().contains("Unable to find")){
                throw new EntityNotFoundException("The hall with id: "+seat.getHall().getId()+" not exist!");
            }
            else if(ex.getRootCause().getMessage().contains("limitation")){
                throw new DataIntegrityViolationException("limitation in number of seat for hall");
            }
            throw new DataIntegrityViolationException("Please Insert valid information");

        }
    }

    public List<Seat> saveList(List<Seat> seatList){
        try{
            return (List<Seat>) seatRepository.saveAll(seatList);
        }
        catch (NestedRuntimeException ex){

            if(ex.getRootCause().getMessage().contains("Unable to find")){
                throw new DataIntegrityViolationException("The place with id: "+seatList.get(0).getHall().getId()+" not exist!");
            }
            else if(ex.getRootCause().getMessage().contains("limitation")){
                throw new DataIntegrityViolationException("limitation in number of hall for place");
            }
            throw new IllegalArgumentException("Please Insert valid information");

        }
    }

    public Seat update(Long id, Seat seat){
        seat.setId(id);
        return seatRepository.save(seat);
    }

    public void deleteById(Long id){
        try{
            seatRepository.deleteById(id);
        }
        catch (Exception ex){
            throw new DataIntegrityViolationException("Seat not found with id: "+id);
        }
    }

    public Seat findById(Long id){
        try{
        return seatRepository.findById(id).get();
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Seat not found with id "+id);
        }
    }
    public List<Seat> findAll(){
        return (List<Seat>) seatRepository.findAll();
    }

    public List<Seat> findAllByHallId(Long hallId){
        return seatRepository.findAllByHallId(hallId);
    }

    public void checkSeatListReserved(List<Long> seatIdList){

        Long id = customSeatRepository.SeatListReserved(seatIdList);
        if(id != null){
            throw new IllegalArgumentException("The seat by id: "+ id+" is reserved");
        }

    }

    public void bookedById(Long id){
        seatRepository.bookedById(id);
    }
    public void cancelById(Long id){
        seatRepository.cancelById(id);
    }

    public void bookedByListId(List<Long> idList){
        seatRepository.bookedByListId(idList);
    }

    public void cancelByListId(List<Long> idList){
        seatRepository.cancelByListId(idList);
    }
}
