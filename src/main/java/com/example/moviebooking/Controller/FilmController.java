package com.example.moviebooking.Controller;

import com.example.moviebooking.repository.entity.Media.Film;
import com.example.moviebooking.repository.entity.Media.Media;
import com.example.moviebooking.repository.entity.MediaShowingPlace;
import com.example.moviebooking.service.media.FilmService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;
    @GetMapping
    public Page<Film> findAll(Pageable pageable){
        return filmService.findAll(pageable);
    }

    @GetMapping
    public Film findById(@RequestParam Long id){
        return filmService.findById(id);
    }

    @GetMapping
    public Page<Film> findByName(Pageable pageable,@RequestParam String name){
        return filmService.findByName(pageable,name);
    }

    @GetMapping("/film-showing")
    public Page<MediaShowingPlace> findFilmShowingPlaceByFilmId(Pageable pageable, @RequestParam Long id ){
        return filmService.findMediaShowingPlaceByFilmId(pageable,id);
    }
    @GetMapping("/film-showing")
    public Page<MediaShowingPlace> findFilmShowingPlaceByPlaceId(Pageable pageable, @RequestParam Long placeId ){
        return filmService.findMediaShowingPlaceByPlaceId(pageable,placeId);
    }

    @PostMapping("/rate")
    public void rateById(@RequestParam Long id, @RequestParam Double rate ){

    }

}
