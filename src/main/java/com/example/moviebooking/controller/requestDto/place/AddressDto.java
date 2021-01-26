package com.example.moviebooking.controller.requestDto.place;


import javax.validation.constraints.NotEmpty;

public class AddressDto {

    @NotEmpty(message = "The line address must not be empty")
    private String line;

    private Double lat;

    private Double lng;

    private String details;

    @NotEmpty(message = "The place id is must not be empty")
    private Long placeId;

    public AddressDto() {
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }
}
