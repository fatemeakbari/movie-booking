package com.example.moviebooking.controller.responseDto.performance;

import com.example.moviebooking.controller.requestDto.media.FilmRequestDto;
import com.example.moviebooking.controller.responseDto.place.HallResponseDto;
import com.example.moviebooking.controller.responseDto.place.PlaceResponseDto;

import java.util.Date;

public class PerformanceResponseDto {

    private Long id;
    private Long mediaId;
    private FilmRequestDto films;
    private PlaceResponseDto place;
    private HallResponseDto hall;
    private Double price;
    private Date showDate;

    public PerformanceResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public FilmRequestDto getFilms() {
        return films;
    }

    public void setFilms(FilmRequestDto films) {
        this.films = films;
    }

    public PlaceResponseDto getPlace() {
        return place;
    }

    public void setPlace(PlaceResponseDto place) {
        this.place = place;
    }

    public HallResponseDto getHall() {
        return hall;
    }

    public void setHall(HallResponseDto hall) {
        this.hall = hall;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }
}
