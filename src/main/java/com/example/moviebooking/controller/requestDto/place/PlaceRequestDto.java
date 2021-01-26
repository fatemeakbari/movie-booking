package com.example.moviebooking.controller.requestDto.place;

import com.example.moviebooking.config.validator.ValidPhoneNumber;
import com.example.moviebooking.entity.place.PlaceWelfareService;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public class PlaceRequestDto {


    @NotEmpty( message = "Name must not be empty")
    private String name;

    @NotEmpty(message = "Manager must not be null")
    private String placeManager;

    @ValidPhoneNumber
    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    private String placeAccess;
    private String address;
    private String history;
    private boolean onlineSale;
    private Integer hallCapacity;
    private Set<PlaceWelfareService> services;

    @Min(value = -90)
    @Max(value = 90)
    private Float latitude;

    @Min(value = -180)
    @Max(value = 180)
    private Float longitude;


    public PlaceRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceManager() {
        return placeManager;
    }

    public void setPlaceManager(String placeManager) {
        this.placeManager = placeManager;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlaceAccess() {
        return placeAccess;
    }

    public void setPlaceAccess(String placeAccess) {
        this.placeAccess = placeAccess;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public boolean isOnlineSale() {
        return onlineSale;
    }

    public void setOnlineSale(boolean onlineSale) {
        this.onlineSale = onlineSale;
    }

    public Integer getHallCapacity() {
        return hallCapacity;
    }

    public void setHallCapacity(Integer hallCapacity) {
        this.hallCapacity = hallCapacity;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Set<PlaceWelfareService> getServices() {
        return services;
    }

    public void setServices(Set<PlaceWelfareService> services) {
        this.services = services;
    }
}
