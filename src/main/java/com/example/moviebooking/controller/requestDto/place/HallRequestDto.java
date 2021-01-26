package com.example.moviebooking.controller.requestDto.place;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class HallRequestDto {

    @NotEmpty(message = "Name must not be empty")
    private String name;

    @Min(value = 0, message = "The seat capacity must be grater than zero")
    private Integer seatCapacity;

    private String position;

    private Long placeId;

    public HallRequestDto() {
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

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }
}
