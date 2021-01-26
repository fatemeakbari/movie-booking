package com.example.moviebooking.service.place;

import com.example.moviebooking.entity.place.Address;
import com.example.moviebooking.repository.place.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address){
        try{
            return addressRepository.save(address);
        }
        catch (NestedRuntimeException ex){
            if(ex.getRootCause().getMessage().contains("Unable to find")){
                throw new EntityNotFoundException("The place with id: "+address.getPlace().getId()+" not exist!");
            }
            throw new IllegalArgumentException("Please insert valid data");
        }
    }

    public Address update(Long id, Address address){
        address.setId(id);
        return addressRepository.save(address);
    }

    public Address findById(Long id){
        try{
            return addressRepository.findById(id).get();
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Address not found with id: "+id);
        }
    }

    public Address findByPlaceId(Long placeId){
        try{
            return addressRepository.findByPlaceId(placeId);
        }
        catch (Exception ex){
            throw new EntityNotFoundException("Address not found with place id: "+placeId);
        }
    }

    public List<Address> findByLineLike(String line){
        return addressRepository.findByLineLike(line);
    }

    public List<Address> findAll(){
        return (List<Address>) addressRepository.findAll();
    }

}
