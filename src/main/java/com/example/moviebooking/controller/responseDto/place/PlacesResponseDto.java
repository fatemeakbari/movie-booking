package com.example.moviebooking.controller.responseDto.place;

import com.example.moviebooking.entity.place.PlaceWelfareService;

import java.util.Set;

public class PlacesResponseDto {

    private Long id;
    private String name;
    private String phoneNumber;
    private String address;
    private Float rate;
    private Set<PlaceWelfareService> services;

    public PlacesResponseDto() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
    public Set<PlaceWelfareService> getServices() {
        return services;
    }

    public void setServices(Set<PlaceWelfareService> services) {
        this.services = services;
    }

}
