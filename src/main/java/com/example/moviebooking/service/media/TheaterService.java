package com.example.moviebooking.service.media;

import com.example.moviebooking.entity.media.Theater;
import com.example.moviebooking.repository.media.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;


    public Theater save(Theater theater){
        return theaterRepository.save(theater);
    }

    public Theater update(Theater theater){
        return theaterRepository.save(theater);
    }

    public Page<Theater> findAll(Pageable pageable){
        return theaterRepository.findAll(pageable);
    }


    public Theater findById(Long id){
        return theaterRepository.findById(id).get();
    }


    public List<Theater> findByName(String name){
        return theaterRepository.findByNameLike(name);
    }

//    public Page<Theater> findByCategory(Pageable pageable, GenreType category){
//        return theaterRepository.findByCategory(pageable,category);
//    }

    public List<Theater> findByDirector(String director){
        return theaterRepository.findByDirector(director);
    }

    public List<Theater> findByProductionYear(Integer productionDate){
        return theaterRepository.findByProductionYear(productionDate);
    }

    public void rateById( Long id, Double rate ){

    }

    public void deleteById(Long id){
        theaterRepository.deleteById(id);
    }
}
