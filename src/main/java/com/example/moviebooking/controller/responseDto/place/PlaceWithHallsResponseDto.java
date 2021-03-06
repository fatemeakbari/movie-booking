package com.example.moviebooking.controller.responseDto.place;

import com.example.moviebooking.entity.place.Address;
import com.example.moviebooking.entity.place.Hall;

import java.util.Set;

public class PlaceWithHallsResponseDto {
    private Long id;

    private String name;

    private String phoneNumber;

    private Integer rate;

    private String details;

    private Integer hallCapacity;

    private Address address;

    private Set<Hall> hallSet;

    public PlaceWithHallsResponseDto() {
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getHallCapacity() {
        return hallCapacity;
    }

    public void setHallCapacity(Integer hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Hall> getHallSet() {
        return hallSet;
    }

    public void setHallSet(Set<Hall> hallSet) {
        this.hallSet = hallSet;
    }
}
