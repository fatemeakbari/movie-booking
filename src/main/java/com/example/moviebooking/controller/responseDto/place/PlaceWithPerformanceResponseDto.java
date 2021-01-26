package com.example.moviebooking.controller.responseDto.place;

import com.example.moviebooking.entity.Performance;

import java.util.List;

public class PlaceWithPerformanceResponseDto {

    private Long id;
    private String name;
    private String placeManager;
    private String phoneNumber;
    private String placeAccess;
    private String address;
    private String history;
    private boolean onlineSale;
    private Integer hallCapacity;
    private Float rate;
    private Float latitude;
    private Float longitude;
    private List<Performance> performanceList;

    public PlaceWithPerformanceResponseDto() {
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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
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

    public List<Performance> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(List<Performance> performanceList) {
        this.performanceList = performanceList;
    }
}
