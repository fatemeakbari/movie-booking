package com.example.moviebooking.service.media;

import com.example.moviebooking.repository.MediaShowingPlaceRepository;
import com.example.moviebooking.repository.entity.Media.Film;
import com.example.moviebooking.repository.entity.MediaShowingPlace;
import com.example.moviebooking.repository.mediaRepository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private MediaShowingPlaceRepository mediaShowingPlaceRepository;

    public Page<Film> findAll(Pageable pageable){
        return filmRepository.findAll(pageable);
    }


    public Film findById(Long id){
        return filmRepository.findById(id).get();
    }


    public Page<Film> findByName(Pageable pageable,String name){
        return filmRepository.findByName(pageable,name);
    }

    public Page<Film> findByCategory(Pageable pageable,String category){
        return filmRepository.findByCategory(pageable,category);
    }

    public Page<Film> findByDirector(Pageable pageable,String director){
        return filmRepository.findByDirector(pageable,director);
    }

    public Page<Film> findByProducer(Pageable pageable,String producer){
        return filmRepository.findByProducer(pageable,producer);
    }

    public Page<MediaShowingPlace> findMediaShowingPlaceByFilmId(Pageable pageable, Long filmId ){
            return mediaShowingPlaceRepository.findByMediaId(pageable,filmId);
    }

    public Page<MediaShowingPlace> findMediaShowingPlaceByPlaceId(Pageable pageable, Long placeId ){
        return mediaShowingPlaceRepository.findByPlaceId(pageable,placeId);
    }

    public void rateById( Long id, Double rate ){

    }
}
