package com.example.moviebooking.service.place;

import com.example.moviebooking.entity.media.MediaRate;
import com.example.moviebooking.entity.place.PlaceRate;
import com.example.moviebooking.repository.place.PlaceRateRepository;
import com.example.moviebooking.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PlaceRateService implements RateService<PlaceRate> {

    @Autowired
    private PlaceRateRepository placeRateRepository;

    @Override
    public PlaceRate save(PlaceRate placeRate) {
        try{
            return placeRateRepository.save(placeRate);
        }
        catch (DataIntegrityViolationException ex){
            if(ex.getMessage().contains("unique_place_user")){
                throw new DataIntegrityViolationException("You can only rate once");
            }
            throw new DataIntegrityViolationException("Please enter valid data.\n"+ex.getMessage());
        }
    }

    @Override
    public Float findAverageByForeignId(Long placeId) {
        Float rate = placeRateRepository.findAverageByPlaceId(placeId);
        if(rate == null){
            return 0f;
        }
        return rate;
    }
}
