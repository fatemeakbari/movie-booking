package com.example.moviebooking.controller.responseDto.place;

import com.example.moviebooking.entity.place.Seat;

import java.util.List;

public class HallWithSeatResponseDto {

    private Long id;

    private String name;

    private Integer seatCapacity;

    private String position;

    private PlaceResponseDto place;

    private List<Seat> seatList;

    public HallWithSeatResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public PlaceResponseDto getPlace() {
        return place;
    }

    public void setPlace(PlaceResponseDto place) {
        this.place = place;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
