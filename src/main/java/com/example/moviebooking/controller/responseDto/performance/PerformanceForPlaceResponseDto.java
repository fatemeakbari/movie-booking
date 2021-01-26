package com.example.moviebooking.controller.responseDto.performance;

import com.example.moviebooking.controller.responseDto.media.FilmsResponseDto;
import com.example.moviebooking.controller.responseDto.place.HallResponseDto;
import com.example.moviebooking.controller.responseDto.place.PlaceResponseDto;

import java.util.Date;

public class PerformanceForPlaceResponseDto {

    private Long id;
    private Long mediaId;
    private FilmsResponseDto place;
    private HallResponseDto hall;
    private Double price;
    private Date showDate;

    public PerformanceForPlaceResponseDto() {
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

    public FilmsResponseDto getPlace() {
        return place;
    }

    public void setPlace(FilmsResponseDto place) {
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
