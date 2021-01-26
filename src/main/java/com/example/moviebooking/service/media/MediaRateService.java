package com.example.moviebooking.service.media;

import com.example.moviebooking.entity.media.MediaRate;
import com.example.moviebooking.repository.media.MediaRateRepository;
import com.example.moviebooking.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class MediaRateService implements RateService<MediaRate> {

    @Autowired
    private MediaRateRepository mediaRateRepository;

    @Override
    public MediaRate save(MediaRate mediaRate) {
        try{
            return mediaRateRepository.save(mediaRate);
        }
        catch (DataIntegrityViolationException ex){
            if(ex.getMessage().contains("unique_media_user")){
                throw new DataIntegrityViolationException("You can only rate once");
            }
            throw new DataIntegrityViolationException("Please enter valid data.\n"+ex.getMessage());
        }
    }



    @Override
    public Float findAverageByForeignId(Long mediaId) {
        Float rate = mediaRateRepository.findAverageByMediaId(mediaId);
        if(rate == null){
            return 0f;
        }
        return rate;
    }
}
