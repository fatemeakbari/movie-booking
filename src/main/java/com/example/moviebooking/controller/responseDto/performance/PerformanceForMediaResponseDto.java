package com.example.moviebooking.controller.responseDto.performance;

import com.example.moviebooking.controller.responseDto.place.HallResponseDto;
import com.example.moviebooking.controller.responseDto.place.PlaceResponseDto;
import com.example.moviebooking.controller.responseDto.place.PlaceWithHallsResponseDto;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PerformanceForMediaResponseDto {

    private Long id;
    private Long mediaId;
    private PlaceResponseDto place;
    private HallResponseDto hall;
    private Double price;
    private Date showDate;

//    private HashMap<PlaceResponseDto, List<HallResponseDto>> places;
//
//    public HashMap<PlaceResponseDto, List<HallResponseDto>> getPlaces() {
//        return places;
//    }
//
//    public void setPlaces(HashMap<PlaceResponseDto, List<HallResponseDto>> places) {
//        this.places = places;
//    }

    public PerformanceForMediaResponseDto() {
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
