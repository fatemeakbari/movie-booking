package com.example.moviebooking.controller.responseDto.place;

public class HallResponseDto {

    private Long id;

    private String name;

    private Integer seatCapacity;

    private String position;

    private Long PlaceId;


    public HallResponseDto() {
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

    public Long getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(Long placeId) {
        PlaceId = placeId;
    }
}
